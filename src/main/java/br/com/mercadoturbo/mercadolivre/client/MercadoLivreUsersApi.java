/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.client;



import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.ItemsResponse;
import br.com.mercadoturbo.mercadolivre.dto.NotasFiscaisRequest;
import br.com.mercadoturbo.mercadolivre.dto.NotasFiscaisResponse;
import br.com.mercadoturbo.mercadolivre.dto.StockLocationsResponse;
import br.com.mercadoturbo.mercadolivre.dto.UsersResponse;
import io.smallrye.mutiny.Uni;
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
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreUsersApi {
    
    // Requisicao ao endpoint do mercado livre que retorna os dados do usuario passa no parametro
    @GET   
    @Produces(MediaType.APPLICATION_JSON)
    Uni<UsersResponse> getUsers(
        @HeaderParam("Authorization") String authorization,
        @PathParam("user_id")String user_id
    );
    
    //Requisicao ao endpoint do mercado livre que retorna os itens da conta 
    @Path("/items/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<ItemsResponse> getItems(
    @HeaderParam("Authorization") String autorization,
            @PathParam("user_id") String user_id,
            @QueryParam("tags") String tags,
            @QueryParam("limit") @DefaultValue("50") int limit,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("user_product_id") String user_product_id
            );
    
    @Path("/stores/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<StockLocationsResponse> getLocations(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")String user_id,
            @QueryParam("tags")String tags,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset")Integer offset);

    @POST
    @Path("/invoices/orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<NotasFiscaisResponse> postNotasFiscais(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            NotasFiscaisRequest request);

}
