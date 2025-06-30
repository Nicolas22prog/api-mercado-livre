/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;
import java.util.List;

import br.com.mercadoturbo.mercadolivre.dto.AttributesRequest;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import br.com.mercadoturbo.mercadolivre.dto.MigrationStatusResponse;
import br.com.mercadoturbo.mercadolivre.dto.MigrationValidationResponse;
import br.com.mercadoturbo.mercadolivre.dto.MultigetResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostItemRequest;
import br.com.mercadoturbo.mercadolivre.dto.PostItemResponse;
import br.com.mercadoturbo.mercadolivre.dto.RelistRequest;
import br.com.mercadoturbo.mercadolivre.dto.VariationFullResponse;
import br.com.mercadoturbo.mercadolivre.dto.VariationRequest;
import br.com.mercadoturbo.mercadolivre.dto.VariationsUpdateRequest;
import br.com.mercadoturbo.mercadolivre.service.MigrationService;
import br.com.mercadoturbo.mercadolivre.service.MigrationValidationService;
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

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemsResource implements Serializable{
    
    @Inject
    MultigetService service;
    
    @Inject
    PostItemService itemService;
    
    @Inject
    MigrationValidationService validation;
    
    @Inject
    MigrationService migration;
    
    
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
    
    
    @GET
    @Path("/{item_id}/user_product_listings/validate") //item_id é o id antigo do produto
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<MigrationValidationResponse> getValidation(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id){
        return validation.fetchValidation(authorization, item_id);
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
    @Path("/{item_id}/migration_live_listing")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<MigrationStatusResponse> getMigrationStatus(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id){
        return migration.fetchMigrationStatus(authorization, item_id);
    }
    
    @GET
    @Path("/{item_id}/variations")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PostItemResponse.Variation> getVariations(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id
               ){
        return service.getVariations(authorization, item_id);
               }

    @GET
    @Path("/{item_id}/variations/{variation_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PostItemResponse.Variation> getVariation(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                @PathParam("variation_id")String variation_id){
        return service.getVariation(authorization, item_id, variation_id);
    }

    @POST
    @Path("/{item_id}/variations")
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

    @PUT
    @Path("/{item_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<AttributesResponse> updateItem(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                AttributesRequest request){
        return service.updateItem(authorization, item_id, request);
    }
}
