package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.RegistroEstadualRequest;
import br.com.mercadoturbo.mercadolivre.dto.RegistroEstadualResponse;
import br.com.mercadoturbo.mercadolivre.service.RegistroEstadualService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users/{user_id}/invoices/state_registry/{CNPJ}/{state}")
public class RegistroEstadualResource {
    
    @Inject
    RegistroEstadualService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<RegistroEstadualResponse> postRegistroEstadual(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("cnpj") String cnpj,
            @PathParam("state") String state,
            RegistroEstadualRequest request){
                return service.fetchRegistroEstadual(authorization, user_id, cnpj, state, request);
            }

     @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<RegistroEstadualResponse> putRegistroEstadual(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("cnpj") String cnpj,
            @PathParam("state") String state,
            RegistroEstadualRequest request){
        return service.updateRegistroEstadual(authorization, user_id, cnpj, state, request);
            }
    
}
