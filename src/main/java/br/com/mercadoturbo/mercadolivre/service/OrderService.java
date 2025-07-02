package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreOrderApi;
import br.com.mercadoturbo.mercadolivre.dto.OrderByIdResponse;
import br.com.mercadoturbo.mercadolivre.dto.OrderResponse;
import br.com.mercadoturbo.mercadolivre.dto.OrderSimpleResponse;
import br.com.mercadoturbo.mercadolivre.dto.ShippingByOrderResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OrderService implements Serializable{

    
    @Inject
    @RestClient
    MercadoLivreOrderApi order;
    
    public Uni<OrderResponse> fetchOrder(String accessToken, Long seller, Integer limit, Integer offset){
        return order.getOrder(accessToken, seller, limit, offset);
    }
    
    public Uni<OrderByIdResponse> fetchOrderById(String accessToken, Long seller, Long orderId, Integer limit, Integer offset){
        return order.getOrderById(accessToken, seller, orderId,limit, offset);
    }
    
    public Uni<OrderResponse> fetchBuyer(String accessToken, Long buyer, Integer limit, Integer offset){
        return order.getBuyer(accessToken, buyer, limit, offset);
    }
    
    public Uni<ShippingByOrderResponse> fetchShippingByOrder(String accessToken, Long order_id){
        return order.getshippingByOrder(accessToken, order_id);
    }

    public Uni<OrderSimpleResponse> fetchOrderDetails(String accessToken, Long orderId) {
        return order.getOrderDetails(accessToken, orderId);
    }
}
