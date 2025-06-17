package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.service.OrderService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.io.Serializable;

@Path("/orders/search")
public class OrderResource implements Serializable{
        
    @Inject
    OrderService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
public Uni<Response> buscarPedidos(
        @HeaderParam("Authorization") String authorization,
        @QueryParam("seller") Long seller,
        @QueryParam("q") Long orderId,
        @QueryParam("buyer") Long buyer,
        @QueryParam("limit") @DefaultValue("50") Integer limit,
        @QueryParam("offset") @DefaultValue("0") Integer offset) {

    if (orderId != null) {
        if (seller == null) {
            return Uni.createFrom().item(Response.status(Response.Status.BAD_REQUEST)
                .entity("O parâmetro 'q' (orderId) só pode ser usado quando 'seller' estiver presente.")
                .build());
        }

        return service.fetchOrderById(authorization, seller, orderId, limit, offset)
            .onItem().transform(resp -> Response.ok(resp).build());
    }

    if (buyer != null) {
        return service.fetchBuyer(authorization, buyer, limit, offset)
            .onItem().transform(resp -> Response.ok(resp).build());
    }

    if (seller != null) {
        return service.fetchOrder(authorization, seller, limit, offset)
            .onItem().transform(resp -> Response.ok(resp).build());
    }

    return Uni.createFrom().item(Response.status(Response.Status.BAD_REQUEST)
        .entity("Informe pelo menos 'seller' ou 'buyer' como parâmetro.")
        .build());
}
}
