package br.com.mercadoturbo.mercadolivre.service;

import java.util.List;

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

    public Uni<RegistroEstadualResponse> deleteRegistroEstadual(String accessToken, String user_id,String cnpj, String state) {
        return mlie.deleteRegistroEstadual(accessToken, user_id, cnpj, state);
    }

    public Uni<List<RegistroEstadualResponse>> getRegistroEstadual(String accessToken, String user_id,String cnpj) {
        return mlie.getRegistroEstadual(accessToken, user_id, cnpj);
    }

    public Uni<RegistroEstadualResponse> updateBatchRegistroEstadual(String accessToken, String user_id,String cnpj, RegistroEstadualRequest request) {
        return mlie.putRegistroEstadualBatch(accessToken, user_id, cnpj, request);
    }
}
