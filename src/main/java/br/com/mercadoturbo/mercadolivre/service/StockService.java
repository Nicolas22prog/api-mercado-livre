package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreStockApi;
import br.com.mercadoturbo.mercadolivre.dto.StockResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class StockService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreStockApi stock;
    
    public Uni<StockResponse> fetchStock(String accessTokne, String user_product_id){
        return stock.getStock(accessTokne, user_product_id);
    }

}
