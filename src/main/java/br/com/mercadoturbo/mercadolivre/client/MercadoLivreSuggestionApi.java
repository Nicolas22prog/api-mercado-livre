package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.ItemsSuggestionsResponse;
import br.com.mercadoturbo.mercadolivre.dto.PriceSuggestionDTO;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/suggestions")
@RegisterRestClient(configKey="mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreSuggestionApi {
        
    
    @GET
    @Path("/user/{user_id}/items")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<ItemsSuggestionsResponse> getItemSug(
        @HeaderParam("Authorization")String authorization,
        @PathParam("user_id")Long user_id);
    
    @GET
    @Path("/items/{item_id}/details")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PriceSuggestionDTO> getPriceSug(
        @HeaderParam("Authorization")String authorization,
        @PathParam("item_id")Long item_id);
}
