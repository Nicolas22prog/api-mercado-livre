package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.AlicotaRequest;
import br.com.mercadoturbo.mercadolivre.dto.AlicotaResponse;
import br.com.mercadoturbo.mercadolivre.service.AlicotaService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users/{user_id}/invoices/tax_rules")
public class AlicotaResource {

    @Inject
    AlicotaService alicotaService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<AlicotaResponse> postAlicota(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            AlicotaRequest request
    ){
        return alicotaService.postAlicota(authorization, user_id, request);
    }
    
}
