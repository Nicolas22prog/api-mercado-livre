package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreTendenciaApi;
import br.com.mercadoturbo.mercadolivre.dto.TendenciasResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TrendsService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreTendenciaApi tendenciaApi;
    
    public Uni<List<TendenciasResponse>> fetchTendencias(String authorization, String siteId) {
        return tendenciaApi.getTendencias(authorization, siteId);
    }

    public Uni<List<TendenciasResponse>> fetchTendenciasByCategory(String authorization, String siteId, String categoryId) {
        return tendenciaApi.getTendenciasByCategory(authorization, siteId, categoryId);
    }
}
