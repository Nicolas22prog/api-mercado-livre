package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreVincularApi;
import br.com.mercadoturbo.mercadolivre.dto.LinkRequest;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class VincularService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreVincularApi vincular;
    
    public Uni<LinkRequest> sendVincular(String accessToken, String item_id,LinkRequest request){
        return vincular.postVincular(accessToken, item_id, request);
    }
}
