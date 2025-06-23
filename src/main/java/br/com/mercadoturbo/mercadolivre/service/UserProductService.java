package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreUserProductApi;
import br.com.mercadoturbo.mercadolivre.dto.SellingAddressUpdate;
import br.com.mercadoturbo.mercadolivre.dto.UserProductResponse;
import br.com.mercadoturbo.mercadolivre.dto.WareHouseResponse;
import br.com.mercadoturbo.mercadolivre.dto.WareHouseUpdate;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class UserProductService implements Serializable{
    @Inject
    @RestClient
    MercadoLivreUserProductApi userProduct;
    
    public Uni<UserProductResponse> fetchUserProduct(String accessToken, String user_product_id){
        return userProduct.getUserProduct(accessToken, user_product_id);
    }

    public Uni<WareHouseResponse> updateStockWH(String accessToken, String user_product_id, WareHouseUpdate update){
        return userProduct.updateStockWH(accessToken, user_product_id, update);
    }
    
    public Uni<SellingAddressUpdate> updateStockSA(String accessToken, String user_product_id, SellingAddressUpdate update){
        return userProduct.updateStockSA(accessToken, user_product_id, update);
    }
}
