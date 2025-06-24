package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreSuggestionApi;
import br.com.mercadoturbo.mercadolivre.dto.ItemsSuggestionsResponse;
import br.com.mercadoturbo.mercadolivre.dto.PriceSuggestionDTO;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class SuggestionsService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreSuggestionApi suggestion;
    
    public Uni<ItemsSuggestionsResponse> fetchItemSug(String accessToken, Long user_id){
        return suggestion.getItemSug(accessToken, user_id);
    }

    public Uni<PriceSuggestionDTO> fetchPriceSug(String accessToken, Long item_id){
        return suggestion.getPriceSug(accessToken, item_id);
    }
}
