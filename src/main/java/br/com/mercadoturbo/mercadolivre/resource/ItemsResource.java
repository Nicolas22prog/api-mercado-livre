/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.MultigetResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostItemRequest;
import br.com.mercadoturbo.mercadolivre.dto.PostItemResponse;
import br.com.mercadoturbo.mercadolivre.dto.RelistRequest;
import br.com.mercadoturbo.mercadolivre.dto.VariationFullResponse;
import br.com.mercadoturbo.mercadolivre.dto.VariationRequest;
import br.com.mercadoturbo.mercadolivre.dto.VariationResponse;
import br.com.mercadoturbo.mercadolivre.dto.VariationsUpdateRequest;
import br.com.mercadoturbo.mercadolivre.service.MultigetService;
import br.com.mercadoturbo.mercadolivre.service.PostItemService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemsResource implements Serializable{
    
    @Inject
    MultigetService service;
    
    @Inject
    PostItemService itemService;
    


    
    @GET
    public Uni<List<MultigetResponse>> getItens(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("ids") String ids,
            @QueryParam("attributes") String attributes
            ){
        return service.fetchItens(authorization, ids, attributes);
    }
    
    @POST
    @Path("/post")//NAO TESTADO AINDA
    public Uni<PostItemResponse> postItem(
            @HeaderParam("Authorization")String authorization,
            PostItemRequest request){
        return itemService.sendItem(authorization, request);
    }
    
    

    
    @PUT
    @Path("/{item_id}/family_name")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PostItemResponse> updateItem(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")Long item_id,
                PostItemRequest request){
        return itemService.updateItem(authorization, item_id, request);
    }

    


    @GET
    @Path("/{item_id: [^/]+ }/variations/{variation_id}") // nao funciona
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<VariationResponse> getVariation(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                @PathParam("variation_id")Long variation_id){
        return service.getVariation(authorization, item_id, variation_id);
    }

    @POST
    @Path("/{item_id: [^/]+}/variations/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<VariationRequest> postVariation(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                VariationRequest request){
        return service.postVariation(authorization, item_id, request);
    }

    @PUT
    @Path("/{item_id}/variations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<VariationFullResponse> updateVariations(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                VariationsUpdateRequest request){
        return service.updateVariations(authorization, item_id, request);
    }

    @DELETE
    @Path("/{item_id}/variations/{variation_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PostItemResponse> deleteVariation(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                @PathParam("variation_id")String variation_id){
        return service.deleteVariation(authorization, item_id, variation_id);
    }

    @POST
    @Path("/{item_id}/relist")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PostItemResponse> relistItem(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                RelistRequest request){
        return service.relistItem(authorization, item_id, request);
    }


}
