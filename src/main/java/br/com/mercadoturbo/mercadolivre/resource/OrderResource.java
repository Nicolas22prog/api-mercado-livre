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
    @QueryParam("seller") Long seller,
    @QueryParam("q") Long orderId,
    @HeaderParam("Authorization") String authorization,
     @QueryParam("limit") @DefaultValue("50") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset) {

    if (orderId == null) {
        return service.fetchOrder(authorization, seller, limit, offset)
            .onItem().transform(resp -> Response.ok(resp).build());
    } else {
        return service.fetchOrderById(authorization, seller, orderId,limit, offset)
            .onItem().transform(resp -> Response.ok(resp).build());
    }
}
}
