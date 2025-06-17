package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.PaymentResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/payments/{payment_id}")
@RegisterRestClient(configKey = "mercado-pago-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoPagoPaymentApi {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<PaymentResponse> getPayment(
            @HeaderParam("Authorization")String authorization,
            @PathParam("payment_id")Long payment_id);
}
