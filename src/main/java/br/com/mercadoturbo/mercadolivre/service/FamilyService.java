package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreFamilyApi;
import br.com.mercadoturbo.mercadolivre.dto.FamilyResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class FamilyService implements Serializable{
    @Inject
    @RestClient
    MercadoLivreFamilyApi family;
    
    public Uni<FamilyResponse> fetchFamilyItems(String accessToken, String site_id, Long family_id){
        return family.getFamilyItems(accessToken, site_id, family_id);
    }

}
