package br.com.mercadoturbo.mercadolivre.client;


import br.com.mercadoturbo.mercadolivre.dto.MultigetResponse;
import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.MigrationValidationResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostItemRequest;
import br.com.mercadoturbo.mercadolivre.dto.PostItemResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

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
            
}
