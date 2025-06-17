package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.PaymentResponse;
import br.com.mercadoturbo.mercadolivre.service.PaymentService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/payments/{payment_id}")
public class PaymentResource implements Serializable{

    
    @Inject
    PaymentService service;
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<PaymentResponse> getPayment(
                @HeaderParam("Authorization")String authorization,
                @PathParam("payment_id") Long payment_id){
        return service.fetchPayment(authorization, payment_id);
    }
}
