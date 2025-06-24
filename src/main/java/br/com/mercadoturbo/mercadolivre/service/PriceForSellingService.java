package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivrePriceForSellingApi;
import br.com.mercadoturbo.mercadolivre.dto.PriceForSellingResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PriceForSellingService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivrePriceForSellingApi sellingPrice;
    
    public Uni<List<PriceForSellingResponse>> fetchPrice(String accessToken,String site_id,String category_id,Integer price,String listing_type_id,String currency_id,String tags){
        return sellingPrice.fetchPrice(accessToken, site_id, category_id, price, listing_type_id, currency_id, tags);
    }

}
