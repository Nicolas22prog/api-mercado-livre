package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreAutomaticPricingApi;
import br.com.mercadoturbo.mercadolivre.dto.AutomaticPricingRequest;
import br.com.mercadoturbo.mercadolivre.dto.AutomaticPricingResponse;
import br.com.mercadoturbo.mercadolivre.dto.PriceAutomationResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PriceAutomationService implements Serializable{
    
    
    @Inject
    @RestClient
    MercadoLivreAutomaticPricingApi automation;
    
    public Uni<AutomaticPricingResponse> fetchRules(String accessToken, String item_id){
        return automation.getRules(accessToken, item_id);
    }

    public Uni<PriceAutomationResponse> sendAutomation(String accessToken, String item_id, AutomaticPricingRequest request){
        return automation.postAutomation(accessToken, item_id, request);
    }
}
