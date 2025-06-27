package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreCatalogApi;
import br.com.mercadoturbo.mercadolivre.dto.CatalogRequest;
import br.com.mercadoturbo.mercadolivre.dto.CatalogResponse;
import br.com.mercadoturbo.mercadolivre.dto.DomainsTrackResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CatalogService implements Serializable {

    @Inject
    @RestClient
    MercadoLivreCatalogApi catalogApi;
    

    public Uni<CatalogResponse> postCatalogSearch(String authorization, Integer offset, Integer limit,CatalogRequest request) {
        return catalogApi.postCatalogSearch(authorization, offset, limit, request);
    }

     public Uni<DomainsTrackResponse> postDomainSearch(String authorization, Integer offset, Integer limit,CatalogRequest request) {
        return catalogApi.postDomainSearch(authorization, offset, limit, request);
    }
}

