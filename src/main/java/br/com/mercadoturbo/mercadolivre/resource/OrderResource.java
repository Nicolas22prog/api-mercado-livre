package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;

import br.com.mercadoturbo.mercadolivre.dto.OrderSimpleResponse;
import br.com.mercadoturbo.mercadolivre.dto.ShippingByOrderResponse;
import br.com.mercadoturbo.mercadolivre.service.OrderService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/orders")
public class OrderResource implements Serializable{
        
    @Inject
    OrderService service;
    
    @GET
    @Path("/search")
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
        
        @GET
        @Path("/{order_id}/shipments")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Uni<ShippingByOrderResponse> getShippingByOrder(
                @HeaderParam("Authorization")String authorization,
                @PathParam("order_id")Long order_id){
            return service.fetchShippingByOrder(authorization, order_id);
        }

        @GET
        @Path("/{order_id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Uni<OrderSimpleResponse> getOrderDetails(
                @HeaderParam("Authorization") String authorization,
                @PathParam("order_id") Long orderId) {
            return service.fetchOrderDetails(authorization, orderId);
                
            
}
}
