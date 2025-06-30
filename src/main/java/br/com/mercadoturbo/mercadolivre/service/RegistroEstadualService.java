package br.com.mercadoturbo.mercadolivre.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreInscricaoEstadualApi;
import br.com.mercadoturbo.mercadolivre.dto.RegistroEstadualRequest;
import br.com.mercadoturbo.mercadolivre.dto.RegistroEstadualResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RegistroEstadualService {
    @Inject
    @RestClient
    MercadoLivreInscricaoEstadualApi mlie;

    public Uni<RegistroEstadualResponse> fetchRegistroEstadual(String accessToken, String user_id,String cnpj, String state, RegistroEstadualRequest request) {
        return mlie.postRegistroEstadual(accessToken, user_id, cnpj, state, request);
    }

    public Uni<RegistroEstadualResponse> updateRegistroEstadual(String accessToken, String user_id,String cnpj, String state, RegistroEstadualRequest request) {
        return mlie.putRegistroEstadual(accessToken, user_id, cnpj, state, request);
    }
}
