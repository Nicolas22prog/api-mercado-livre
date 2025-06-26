package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.AttributesItemsResponse;
import br.com.mercadoturbo.mercadolivre.dto.LinkRequest;
import br.com.mercadoturbo.mercadolivre.dto.PictureUpdateRequest;
import br.com.mercadoturbo.mercadolivre.service.AttributesService;
import br.com.mercadoturbo.mercadolivre.service.VincularService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/items/{item_id}")
public class VincularResource {

    @Inject
    AttributesService attributesService;
    
    @Inject
    VincularService service;
   
    @POST
    @Path("/pictures")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<LinkRequest> postVincular(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            LinkRequest request){
        return service.sendVincular(authorization, item_id, request);
    }
    
    @POST
    @Path("/update-picture")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PictureUpdateRequest> updatePicture(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            PictureUpdateRequest request){
        return service.updatePicture(authorization, item_id, request);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<AttributesItemsResponse> getItemAttributes(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                @QueryParam("attributes")String attributes,
                @QueryParam("include_internal_attributes")Boolean include_internal_attributes){
        return attributesService.fetchItemsAttributes(authorization, item_id, attributes, include_internal_attributes);
    }
}
