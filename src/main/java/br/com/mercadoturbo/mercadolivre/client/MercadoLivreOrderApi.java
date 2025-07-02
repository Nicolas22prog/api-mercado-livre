package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.OrderByIdResponse;
import br.com.mercadoturbo.mercadolivre.dto.OrderResponse;
import br.com.mercadoturbo.mercadolivre.dto.OrderSimpleResponse;
import br.com.mercadoturbo.mercadolivre.dto.ShippingByOrderResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/orders")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreOrderApi{
        
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<OrderResponse> getOrder(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("seller")Long seller,
            @QueryParam("limit") @DefaultValue("50") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset
            );
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<OrderByIdResponse> getOrderById(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("seller")Long seller,
            @QueryParam("q") Long q, // q eh o id do pedido
            @QueryParam("limit") @DefaultValue("50") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<OrderResponse> getBuyer(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("buyer") Long buyer, // q eh o id do comprador
            @QueryParam("limit") @DefaultValue("50") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset);
    
    
    @GET
    @Path("/{order_id}/shipments")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<ShippingByOrderResponse> getshippingByOrder(
            @HeaderParam("Authorization")String authorization,
            @PathParam("order_id")Long order_id);


        @GET
        @Path("/{order_id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        Uni<OrderSimpleResponse> getOrderDetails(
                @HeaderParam("Authorization") String authorization,
                @PathParam("order_id") Long orderId);
}
