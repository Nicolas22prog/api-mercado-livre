package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.ItemsSuggestionsResponse;
import br.com.mercadoturbo.mercadolivre.dto.PriceSuggestionDTO;
import br.com.mercadoturbo.mercadolivre.service.SuggestionsService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/suggestions")
public class SuggestionsResource implements Serializable{

    @Inject
    SuggestionsService service;
    
    @GET
    @Path("/user/{user_id}/items")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<ItemsSuggestionsResponse> getItemSug(
        @HeaderParam("Authorization")String authorization,
        @PathParam("user_id")Long user_id){
        return service.fetchItemSug(authorization, user_id);
    }
    
    
    @GET
    @Path("/items/{item_id}/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PriceSuggestionDTO> getPriceSug(
        @HeaderParam("Authorization")String authorization,
        @PathParam("item_id")Long item_id){
        return service.fetchPriceSug(authorization, item_id);
    }
}
