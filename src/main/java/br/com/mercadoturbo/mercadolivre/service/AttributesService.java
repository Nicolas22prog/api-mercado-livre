package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreAttributesApi;
import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsApi;
import br.com.mercadoturbo.mercadolivre.dto.AttributesConditionalRequest;
import br.com.mercadoturbo.mercadolivre.dto.AttributesConditionalResponse;
import br.com.mercadoturbo.mercadolivre.dto.AttributesItemsResponse;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import br.com.mercadoturbo.mercadolivre.dto.TechinicalSpecsResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class AttributesService implements Serializable{

    @Inject
    @RestClient
    MercadoLivreAttributesApi attributes;
    
    @Inject
    @RestClient
    MercadoLivreItemsApi item;
    
    public Uni<List<AttributesResponse>> fetchAttributes(String accessToken, String category_id){
        return attributes.getAttributes(accessToken, category_id);
    }
    
    public Uni<TechinicalSpecsResponse> fetchTechInput(String accessToken, String category_id){
        return attributes.getTechInput(accessToken, category_id);
    }
    
    public Uni<TechinicalSpecsResponse> fetchOutput(String accessToken, String category_id){
        return attributes.getTechOutput(accessToken, category_id);
    }
    
    public Uni<AttributesConditionalResponse> sendConditional(String accessToken, String category_id,AttributesConditionalRequest request){
        return attributes.postConditional(accessToken, category_id, request);
    }
    
    public Uni<AttributesItemsResponse> fetchItemsAttributes(String accessToken, String item_id, String attributes, Boolean include_internal_attributes){
        return item.getItemAttributes(accessToken, item_id, attributes, include_internal_attributes);
    }
}
