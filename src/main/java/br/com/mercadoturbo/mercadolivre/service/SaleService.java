package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreSaleApi;
import br.com.mercadoturbo.mercadolivre.dto.PostPriceRequest;
import br.com.mercadoturbo.mercadolivre.dto.PricesResponse;
import br.com.mercadoturbo.mercadolivre.dto.QuantityPriceRequest;
import br.com.mercadoturbo.mercadolivre.dto.QuantityPriceResponse;
import br.com.mercadoturbo.mercadolivre.dto.SaleDTO;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class SaleService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreSaleApi sale;

    public Uni<SaleDTO> fetchSales(String accessToken, String item_id, String contexty){
        return sale.getSale(accessToken, item_id, contexty);
    }
    
    public Uni<PricesResponse> fetchPrices(String accessToken, String item_id){
        return sale.getPrices(accessToken, item_id);
    }
    
    public Uni<PostPriceRequest> sendPrice(String accessToken, String item_id,PostPriceRequest request){
        return sale.postPrice(accessToken, item_id, request);
    }
    
    public Uni<QuantityPriceResponse> sendQuantityPrice(String accessToken, String item_id, QuantityPriceRequest request){
        return sale.postPriceQuantity(accessToken, item_id, request);
    }
}
