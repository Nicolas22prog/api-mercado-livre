package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.ShipmentDocumentsResponse;
import br.com.mercadoturbo.mercadolivre.dto.ShipmentResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/shipments/{shipment_id}")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreShipmentApi {
        
    
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        Uni<ShipmentResponse> getShipment(
                @HeaderParam("Authorization")String authorization,
                @PathParam("shipment_id")Long shipment_id);

        @GET
        @Path("/billing_info")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        Uni<ShipmentDocumentsResponse> getShipmentDocuments(
                @HeaderParam("Authorization")String authorization,
                @PathParam("shipment_id")Long shipment_id);
}
