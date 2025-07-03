package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreMsgAdicionalApi;
import br.com.mercadoturbo.mercadolivre.dto.MensagemAdicionalRequest;
import br.com.mercadoturbo.mercadolivre.dto.MensagemAdicionalResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MsgAdicionalService implements Serializable {

    @Inject
    @RestClient
    MercadoLivreMsgAdicionalApi msgAdicionalApi;
    

    public Uni<MensagemAdicionalResponse> createMensagemAdicional(String accessToken, String userId, MensagemAdicionalRequest request) {
        return msgAdicionalApi.createMensagemAdicional(accessToken, userId, request);
    }

    public Uni<MensagemAdicionalResponse> updateMensagemAdicional(String accessToken, String userId, MensagemAdicionalRequest request) {
        return msgAdicionalApi.updateMensagemAdicional(accessToken, userId, request);
    }

    public Uni<List<MensagemAdicionalResponse>> getMensagemAdicional(String accessToken, String userId) {
        return msgAdicionalApi.getMensagemAdicional(accessToken, userId);
    }

    public Uni<Void> deleteMensagemAdicional(String accessToken, String userId, Integer messageId, String callerId) {
        return msgAdicionalApi.deleteMensagemAdicional(accessToken, userId, messageId, callerId);
    }
}
