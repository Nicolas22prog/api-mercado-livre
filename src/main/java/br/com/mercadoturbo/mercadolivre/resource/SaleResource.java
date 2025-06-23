package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.SaleDTO;
import br.com.mercadoturbo.mercadolivre.service.SaleService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/items/{item_id}/sale_price")
public class SaleResource implements Serializable{

    @Inject
    SaleService service;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<SaleDTO> getSale(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("context")String context){
        return service.fetchSales(authorization, item_id, context);
    }
}
