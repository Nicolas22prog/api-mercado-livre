package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsApi;
import br.com.mercadoturbo.mercadolivre.dto.MigrationValidationResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MigrationValidationService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreItemsApi validation;
    
    
    public Uni<MigrationValidationResponse> fetchValidation(String accessToken, String item_id){
        return validation.getValidation(item_id, item_id);
    }

}
