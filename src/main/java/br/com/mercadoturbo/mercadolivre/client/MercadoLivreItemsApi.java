package br.com.mercadoturbo.mercadolivre.client;


import java.util.List;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AttributesItemsResponse;
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
import io.smallrye.mutiny.Uni;
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
                @QueryParam("include_attributes")String include_attributes, // Opcional, exemplo da API: "include_attributes=all"
                @QueryParam("include_internal_attributes")Boolean include_internal_attributes);

    @PUT
    @Path("/{item_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AttributesResponse> updateItem(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                AttributesRequest request);


    @GET
    @Path("/{item_id}/variations")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PostItemResponse.Variation> getVariations(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id
               );

    @GET
    @Path("/{item_id}/variations/{variation_id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PostItemResponse.Variation> getVariation(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                @PathParam("variation_id")String variation_id);

    @POST
    @Path("/{item_id}/variations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<VariationRequest> postVariation(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                VariationRequest request);

    @PUT
    @Path("/{item_id}/variations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<VariationFullResponse> updateVariations(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                VariationsUpdateRequest request);

    @DELETE
    @Path("/{item_id}/variations/{variation_id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PostItemResponse> deleteVariation(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                @PathParam("variation_id")String variation_id);

    @POST
    @Path("/{item_id}/relist")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PostItemResponse> relistItem(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id,
                RelistRequest request);
}
