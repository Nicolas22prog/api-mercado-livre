package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class AttributesService implements Serializable{

    @Inject
    @RestClient
    MercadoLivreAttributesApi attributes;
    
    public Uni<AttributesResponse> fetchAttributes(String accessToken, String category_id){
        return attributes.getAttributes(accessToken, category_id);
    }
}
