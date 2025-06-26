package br.com.mercadoturbo.mercadolivre.client;


import java.util.List;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AttributesItemsResponse;
import br.com.mercadoturbo.mercadolivre.dto.AttributesRequest;
import br.com.mercadoturbo.mercadolivre.dto.MigrationStatusResponse;
import br.com.mercadoturbo.mercadolivre.dto.MigrationValidationResponse;
import br.com.mercadoturbo.mercadolivre.dto.MultigetResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostItemRequest;
import br.com.mercadoturbo.mercadolivre.dto.PostItemResponse;
import io.smallrye.mutiny.Uni;
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

@Path("/items")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreItemsApi {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)           
    Uni<List<MultigetResponse>> getMultigetItens(
        @HeaderParam("Authorization") String authorization,
        @QueryParam("ids") String ids,
        @QueryParam("attributes") String attributes
        
);
    

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PostItemResponse> postItem(
            @HeaderParam("Authorization")String authorization,
            PostItemRequest request);
    
    
    @GET
    @Path("/{item_id}/user_product_listings/validate")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<MigrationValidationResponse> getValidation(
                    @HeaderParam("Authorization")String authorization,
                    @PathParam("item_id")String item_id);
         
    
    @PUT
    @Path("/{item_id}/family_name")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PostItemResponse> putItem(
                @HeaderParam("Authorizarion")String authorization,
                @PathParam("item_id") Long item_id,
                PostItemRequest request);
       
    @GET
    @Path("/{item_id}/migration_live_listing")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<MigrationStatusResponse> getMigrationStatus(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id);
    
    @GET
    @Path("/{item_id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AttributesItemsResponse> getItemAttributes(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                @QueryParam("attributes")String attributes,
                @QueryParam("include_internal_attributes")Boolean include_internal_attributes);

    @PUT
    @Path("/{item_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AttributesRequest> updateItem(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                AttributesRequest request);

}
