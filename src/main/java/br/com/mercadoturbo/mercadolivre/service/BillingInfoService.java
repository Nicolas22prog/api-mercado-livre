package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreBillingInfoApi;
import br.com.mercadoturbo.mercadolivre.dto.BillingInfoResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BillingInfoService implements Serializable {

    @Inject
    @RestClient
    MercadoLivreBillingInfoApi billingInfoApi;
    

    public Uni<BillingInfoResponse> getBillingInfo(String accessToken, Long orderId) {
        return billingInfoApi.getBillingInfo(accessToken, orderId);
    }
}
