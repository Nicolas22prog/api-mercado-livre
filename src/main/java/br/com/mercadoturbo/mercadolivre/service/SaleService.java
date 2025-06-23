package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreSaleApi;
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
        return sale.getPrices(accessToken, item_id, contexty);
    }
    
}
