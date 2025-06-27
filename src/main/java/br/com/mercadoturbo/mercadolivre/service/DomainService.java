package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreDomainApi;
import br.com.mercadoturbo.mercadolivre.dto.DomainResponse;
import br.com.mercadoturbo.mercadolivre.dto.MedidasRequest;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DomainService implements Serializable {
    

    @Inject
    @RestClient
    MercadoLivreDomainApi domainApi;

    public Uni<DomainResponse> getTechSpecs(String authorization, String domainId) {
        return domainApi.getTechSpecs(authorization, domainId);
    }
    
    public Uni<DomainResponse> postTechSpecs(String authorization, String domainId ,String section ,MedidasRequest request) {
        return domainApi.postTechSpecs(authorization, domainId, section, request);
    }
}
