package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreFamilyApi;
import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsApi;
import br.com.mercadoturbo.mercadolivre.dto.MigrationRequest;
import br.com.mercadoturbo.mercadolivre.dto.MigrationStatusResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MigrationService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreFamilyApi migration;
    
    @Inject
    @RestClient
    MercadoLivreItemsApi migrationStatus;
    
    public Uni<MigrationRequest> postMigration(String accessToken, String site_id, MigrationRequest request){
        return migration.postMigration(accessToken, site_id, request);
    }

    public Uni<MigrationStatusResponse> fetchMigrationStatus(String accessToken, String item_id){
        return migrationStatus.getMigrationStatus(accessToken, item_id);
    }
}
