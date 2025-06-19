package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreShipmentApi;
import br.com.mercadoturbo.mercadolivre.dto.ShipmentResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ShipmentService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreShipmentApi shipment;
    
    public Uni<ShipmentResponse> fetchShipment(String accessToken, Long shipment_id){
        return shipment.getShipment(accessToken, shipment_id);
    }

}
