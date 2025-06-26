package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreBrandApi;
import br.com.mercadoturbo.mercadolivre.dto.BrandMetric;
import br.com.mercadoturbo.mercadolivre.dto.KnownAttributesRequest;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BrandService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreBrandApi brand;
    
    
    public Uni<List<BrandMetric>> sendAttributes(String accessToken, String domain_id, String attribute_id, KnownAttributesRequest request){
        return brand.postAttribute(accessToken, domain_id, attribute_id, request);
    }

}
