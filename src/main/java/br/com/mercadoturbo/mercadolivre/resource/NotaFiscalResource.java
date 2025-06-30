package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.NotaFiscalResponse;
import br.com.mercadoturbo.mercadolivre.service.NotaFiscalService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/users/{user_id}/invoices")
public class NotaFiscalResource {
    
    @Inject
    NotaFiscalService service;

    @GET
    @Path("/{invoice_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<NotaFiscalResponse> getNotaFiscal(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("invoice_id") String invoice_id) {
        return service.getNotaFiscal(authorization, user_id, invoice_id);
            }

    @GET
    @Path("/order_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<NotaFiscalResponse> getNotaFiscalByOrderId(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("order_id") Long order_id) {
        return service.getNotaFiscalByOrderId(authorization, user_id, order_id);
    }

    @GET
    @Path("/shipment_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<NotaFiscalResponse> getNotaFiscalByShipmentId(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("shipment_id") Long shipment_id) {
        return service.getNotaFiscalByShipmentId(authorization, user_id, shipment_id);
    }
}
