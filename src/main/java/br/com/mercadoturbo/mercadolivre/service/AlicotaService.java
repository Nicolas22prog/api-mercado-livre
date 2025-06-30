package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreTaxesApi;
import br.com.mercadoturbo.mercadolivre.dto.AlicotaRequest;
import br.com.mercadoturbo.mercadolivre.dto.AlicotaResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AlicotaService implements Serializable {
    @Inject
    @RestClient
    MercadoLivreTaxesApi mlt;

    public Uni<AlicotaResponse> postAlicota(String accessToken, String user_id, AlicotaRequest request) {
        return mlt.postAlicota(accessToken, user_id, request);
    }
    
}
