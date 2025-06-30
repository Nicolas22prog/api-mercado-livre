package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreBrandApi;
import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsApi;
import br.com.mercadoturbo.mercadolivre.dto.AttributesRequest;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import br.com.mercadoturbo.mercadolivre.dto.BrandMetric;
import br.com.mercadoturbo.mercadolivre.dto.KnownAttributesRequest;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BrandService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreBrandApi brand;

    @Inject
    @RestClient
    MercadoLivreItemsApi items;
    
    
    public Uni<List<BrandMetric>> sendAttributes(String accessToken, String domain_id, String attribute_id,
            KnownAttributesRequest request) {
        return brand.postAttribute(accessToken, domain_id, attribute_id, request);
    }

    public Uni<AttributesResponse> updateAttributes(String accessToken, String item_id ,AttributesRequest request) {
        return items.updateItem(accessToken, item_id, request); 
    }
}
