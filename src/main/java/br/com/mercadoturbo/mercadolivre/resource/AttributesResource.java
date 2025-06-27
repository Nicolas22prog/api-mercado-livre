package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;
import java.util.List;

import br.com.mercadoturbo.mercadolivre.dto.AttributesConditionalRequest;
import br.com.mercadoturbo.mercadolivre.dto.AttributesConditionalResponse;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import br.com.mercadoturbo.mercadolivre.dto.TechinicalSpecsResponse;
import br.com.mercadoturbo.mercadolivre.service.AttributesService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/categories/{category_id}")
public class AttributesResource implements Serializable{
    
    @Inject
    AttributesService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/attributes")
    public Uni<List<AttributesResponse>> getAttributes(
        @HeaderParam("Authorization") String authorization,
        @PathParam("category_id")String category_id){
        return service.fetchAttributes(authorization, category_id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/technical_specs/input")
    public Uni<TechinicalSpecsResponse> getTechInput(
            @HeaderParam("Authorization") String authorization,
            @PathParam("category_id")String category_id){
        return service.fetchTechInput(authorization, category_id);
    }
          
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/technical_specs/output")
    public Uni<TechinicalSpecsResponse> getTechOutput(
            @HeaderParam("Authorization") String authorization,
            @PathParam("category_id")String category_id){
        return service.fetchOutput(authorization, category_id);
    }
 
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/attributes/conditional")
    public Uni<AttributesConditionalResponse> postConditional(
        @HeaderParam("Authorization")String authorization,
        @PathParam("category_id")String category_id,
        AttributesConditionalRequest request){
        return service.sendConditional(authorization, category_id, request);
    }

    
}

