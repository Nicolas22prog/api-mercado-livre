package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.DescriptionResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostDescriptionRequest;
import br.com.mercadoturbo.mercadolivre.service.DescriptionService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/items/{item_id}")
public class DescriptionResource implements Serializable{

    @Inject 
    DescriptionService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<DescriptionResponse> getDescription(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id){
        return service.fetchDescription(authorization, item_id);
        
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<DescriptionResponse> postDescription(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            PostDescriptionRequest request){
        return service.sendDescription(authorization, item_id, request);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<DescriptionResponse> putDescription(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("api_version") @DefaultValue("2") int api_version,
            PostDescriptionRequest request){
        return service.updateDescription(authorization, item_id, api_version, request);
    }
}
