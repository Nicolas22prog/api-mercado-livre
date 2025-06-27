/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.client;



import br.com.mercadoturbo.mercadolivre.dto.UsersResponse;
import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.ItemsResponse;
import br.com.mercadoturbo.mercadolivre.dto.StockLocationsResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

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
}
