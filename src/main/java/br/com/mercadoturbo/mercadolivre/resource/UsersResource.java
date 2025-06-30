/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;

import br.com.mercadoturbo.mercadolivre.dto.ItemsResponse;
import br.com.mercadoturbo.mercadolivre.dto.NotasFiscaisRequest;
import br.com.mercadoturbo.mercadolivre.dto.NotasFiscaisResponse;
import br.com.mercadoturbo.mercadolivre.dto.StockLocationsResponse;
import br.com.mercadoturbo.mercadolivre.dto.UsersResponse;
import br.com.mercadoturbo.mercadolivre.service.UsersService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/users/{user_id}")
public class UsersResource implements Serializable{
    @Inject
    private UsersService us;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<UsersResponse> getUsers(
            @HeaderParam("Authorization") String authorization,            
            @PathParam("user_id") String user_id){
        return us.fetchUsers(authorization, user_id);
    }
    
    
    @GET
    @Path("/items/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<ItemsResponse> getItems(
            @HeaderParam("Authorization") String authorization,            
            @PathParam("user_id") String user_id,
            @QueryParam("tags")String tags,
            @QueryParam("limit") @DefaultValue("50") int limit,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("user_product_id")String user_product_id){
        return us.fetchItems(authorization, user_id,tags, limit, offset, user_product_id);
    }
    
    @Path("/stores/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<StockLocationsResponse> getLocations(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")String user_id,
            @QueryParam("tags")String tags,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset")Integer offset){
        return us.fetchLocations(authorization, user_id, tags, limit, offset);
    }

    @POST
    @Path("/invoices/orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<NotasFiscaisResponse> postNotasFiscais(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            NotasFiscaisRequest request) {
        return us.postNotasFiscais(authorization, user_id, request);
    }
}
