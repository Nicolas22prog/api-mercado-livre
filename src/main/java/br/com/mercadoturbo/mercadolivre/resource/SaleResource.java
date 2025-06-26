package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.PostPriceRequest;
import br.com.mercadoturbo.mercadolivre.dto.PricesResponse;
import br.com.mercadoturbo.mercadolivre.dto.QuantityPriceRequest;
import br.com.mercadoturbo.mercadolivre.dto.QuantityPriceResponse;
import br.com.mercadoturbo.mercadolivre.dto.SaleDTO;
import br.com.mercadoturbo.mercadolivre.service.SaleService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/items/{item_id}")
public class SaleResource implements Serializable{

    @Inject
    SaleService service;
    
    
    @GET
    @Path("/sale_price")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<SaleDTO> getSale(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("context")String context){
        return service.fetchSales(authorization, item_id, context);
    }
    
    @GET
    @Path("/prices")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PricesResponse> getPrices(   
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id){
        return service.fetchPrices(authorization, item_id);
    }
    
        @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/prices/standard")
    public Uni<PostPriceRequest> postPrice(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            PostPriceRequest request){
        return service.sendPrice(authorization, item_id, request);
    }
    
        @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/prices/standard/quantity")
    public Uni<QuantityPriceResponse> postPrice(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            QuantityPriceRequest request){
        return service.sendQuantityPrice(authorization, item_id, request);
    }
}
