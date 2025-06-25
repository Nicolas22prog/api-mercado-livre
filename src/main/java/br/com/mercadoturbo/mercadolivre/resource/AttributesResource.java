package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.client.AttributesService;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/categories/{category_id}/attributes")
public class AttributesResource implements Serializable{
    
    @Inject
    AttributesService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public Uni<AttributesResponse> getAttributes(
        @HeaderParam("Authorization") String authorization,
        @PathParam("category_id")String category_id){
        return service.fetchAttributes(authorization, category_id);
    }
}
