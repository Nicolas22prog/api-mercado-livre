package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;

import br.com.mercadoturbo.mercadolivre.dto.ShipmentDocumentsResponse;
import br.com.mercadoturbo.mercadolivre.dto.ShipmentResponse;
import br.com.mercadoturbo.mercadolivre.service.ShipmentService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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

    @GET
    @Path("/billing_info")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ShipmentDocumentsResponse> getShipmentDocuments(
                @HeaderParam("Authorization")String authorization,
                @PathParam("shipment_id")Long shipment_id){
        return service.fetchShipmentDocuments(authorization, shipment_id);
}
}
