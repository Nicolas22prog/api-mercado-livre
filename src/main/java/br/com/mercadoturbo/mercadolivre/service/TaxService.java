package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreTaxesApi;
import br.com.mercadoturbo.mercadolivre.dto.TaxMessageRequest;
import br.com.mercadoturbo.mercadolivre.dto.TaxMessageResponse;
import br.com.mercadoturbo.mercadolivre.dto.TaxesResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TaxService implements Serializable{

    @Inject
    @RestClient
    MercadoLivreTaxesApi mlt;

    public Uni<TaxMessageResponse> sendTaxMessage(String accessToken, String user_id, TaxMessageRequest request) {
        return mlt.postTaxes(accessToken, user_id, request);
    }

        public Uni<TaxesResponse> fetchTaxes(String accessToken, String user_id) {
        return mlt.getTaxes(accessToken, user_id);
    }

    public Uni<TaxesResponse> fetchTaxesMessages(String accessToken, String user_id,
            Integer limit, Integer offset) {
        return mlt.getTaxMessages(accessToken, user_id, limit, offset);
    }

    public Uni<TaxMessageResponse> fetchTaxesMessagesById(String accessToken, String user_id, Long message_id) {
        return mlt.getTaxMessageById(accessToken, user_id, message_id);
    }

    public Uni<TaxMessageResponse> updateTaxMessage(String accessToken, String user_id, Long message_id, TaxMessageRequest request) {
        return mlt.putTaxMessage(accessToken, user_id, message_id, request);
    }

    public Uni<TaxMessageResponse> deleteTaxMessage(String accessToken, String user_id, Long message_id) {
        return mlt.deleteTaxMessage(accessToken, user_id, message_id);
    }
}
