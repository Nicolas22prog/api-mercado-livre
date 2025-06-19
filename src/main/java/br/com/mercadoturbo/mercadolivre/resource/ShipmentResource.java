package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.ShipmentResponse;
import br.com.mercadoturbo.mercadolivre.service.ShipmentService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/shipments/{shipment_id}")
public class ShipmentResource implements Serializable{
    
    @Inject
    ShipmentService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<ShipmentResponse> getShipment(
                @HeaderParam("Authorization")String authorization,
                @PathParam("shipment_id")Long shipment_id){
        return service.fetchShipment(authorization, shipment_id);
    }
}
