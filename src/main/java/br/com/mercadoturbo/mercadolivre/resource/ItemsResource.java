/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.MigrationValidationResponse;
import br.com.mercadoturbo.mercadolivre.dto.MultigetResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostItemRequest;
import br.com.mercadoturbo.mercadolivre.dto.PostItemResponse;
import br.com.mercadoturbo.mercadolivre.service.MigrationValidationService;
import br.com.mercadoturbo.mercadolivre.service.MultigetService;
import br.com.mercadoturbo.mercadolivre.service.PostItemService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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
    
    @Inject
    MigrationValidationService validation;
    
    @GET
    public Uni<List<MultigetResponse>> getItens(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("ids") String ids,
            @QueryParam("attributes") String attributes
            ){
        return service.fetchItens(authorization, ids, attributes);
    }
    
    @POST  //NAO TESTADO AINDA
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
}
