package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.OrderByIdResponse;
import br.com.mercadoturbo.mercadolivre.dto.OrderResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/orders/search")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreOrderApi{
        
    @GET
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
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<OrderByIdResponse> getOrderById(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("seller")Long seller,
            @QueryParam("q") Long q, // q eh o id do pedido
            @QueryParam("limit") @DefaultValue("50") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<OrderResponse> getBuyer(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("buyer") Long buyer, // q eh o id do comprador
            @QueryParam("limit") @DefaultValue("50") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset);
}
