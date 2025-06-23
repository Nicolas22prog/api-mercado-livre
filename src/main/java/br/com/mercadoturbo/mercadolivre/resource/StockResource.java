package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.StockResponse;
import br.com.mercadoturbo.mercadolivre.service.StockService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("user-products/{user_product_id}/stock")
public class StockResource implements Serializable{
    @Inject
    StockService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<StockResponse> getStock(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_product_id")String user_product_id){
        return service.fetchStock(authorization, user_product_id);
    }

}
