package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.NotaFiscalResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users/{user_id}/invoices")
@RegisterRestClient(configKey="mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface  MercadoLivreNotaFiscalApi {
 
    @GET
    @Path("/{invoice_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<NotaFiscalResponse> getNotaFiscal(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("invoice_id") String invoice_id);

    @GET
    @Path("/{order_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<NotaFiscalResponse> getNotaFiscalByOrderId(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("order_id") Long order_id);

    @GET
    @Path("/{shipment_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<NotaFiscalResponse> getNotaFiscalByShipmentId(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("shipment_id") Long shipment_id);
}