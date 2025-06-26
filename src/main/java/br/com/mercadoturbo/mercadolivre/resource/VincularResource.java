package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.AttributesItemsResponse;
import br.com.mercadoturbo.mercadolivre.dto.AttributesRequest;
import br.com.mercadoturbo.mercadolivre.dto.LinkRequest;
import br.com.mercadoturbo.mercadolivre.dto.PictureUpdateRequest;
import br.com.mercadoturbo.mercadolivre.service.AttributesService;
import br.com.mercadoturbo.mercadolivre.service.BrandService;
import br.com.mercadoturbo.mercadolivre.service.VincularService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/items/{item_id}")
public class VincularResource {

    @Inject
    AttributesService attributesService;
    
    @Inject
    VincularService service;

    @Inject
    BrandService brandService;
   
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

    @PUT
    @Path("/{item_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<AttributesRequest> updateItem(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                AttributesRequest request){
                    return brandService.updateAttributes(authorization, item_id, request);
                }
}
