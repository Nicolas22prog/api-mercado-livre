package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreNotaFiscalApi;
import br.com.mercadoturbo.mercadolivre.dto.NotaFiscalResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NotaFiscalService implements Serializable {

    @Inject
    @RestClient
    MercadoLivreNotaFiscalApi notaFiscalApi;


    public Uni<NotaFiscalResponse> getNotaFiscal(String accessToken, String user_id, String invoice_id) {
        return notaFiscalApi.getNotaFiscal(accessToken, user_id, invoice_id);
    }

    public Uni<NotaFiscalResponse> getNotaFiscalByOrderId(String accessToken, String user_id, Long order_id) {
        return notaFiscalApi.getNotaFiscalByOrderId(accessToken, user_id, order_id);
    }

    public Uni<NotaFiscalResponse> getNotaFiscalByShipmentId(String accessToken, String user_id, Long shipment_id) {
        return notaFiscalApi.getNotaFiscalByShipmentId(accessToken, user_id, shipment_id);
    }
    
}
