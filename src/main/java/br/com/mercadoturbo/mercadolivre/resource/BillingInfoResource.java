package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;

import br.com.mercadoturbo.mercadolivre.dto.BillingInfoResponse;
import br.com.mercadoturbo.mercadolivre.service.BillingInfoService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/orders/{order_id}/billing_info")
public class BillingInfoResource implements Serializable{
    
    @Inject
    BillingInfoService service;


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<BillingInfoResponse> getBillingInfo(
            @HeaderParam("Authorization") String authorization,
            @HeaderParam("x-version") String version,
            @PathParam("order_id") Long orderId) {
        return service.getBillingInfo(authorization ,version ,orderId);
    }
}
