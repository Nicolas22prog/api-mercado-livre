package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoPagoPaymentApi;
import br.com.mercadoturbo.mercadolivre.dto.PaymentResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PaymentService implements Serializable{

    
    @Inject
    @RestClient
    MercadoPagoPaymentApi payment;
    
    public Uni<PaymentResponse> fetchPayment(String accessToken, long payment_id){
        return payment.getPayment(accessToken, payment_id);
    }
}
