package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreDescriptionApi;
import br.com.mercadoturbo.mercadolivre.dto.DescriptionResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostDescriptionRequest;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class DescriptionService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreDescriptionApi description;
    
    public Uni<DescriptionResponse> fetchDescription(String accessToken, String item_id){
        return description.getDescription(accessToken, item_id);
    }
    
    public Uni<DescriptionResponse> sendDescription(String accessToken, String item_id, PostDescriptionRequest request){
        return description.postDescription(accessToken, item_id, request);
    }

    public Uni<DescriptionResponse> updateDescription(String accessToken, String item_id, int api_version,PostDescriptionRequest request){
        return description.updateDescription(accessToken, item_id, api_version ,request);
    }
}
