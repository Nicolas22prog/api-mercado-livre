package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.MensagemAdicionalRequest;
import br.com.mercadoturbo.mercadolivre.dto.MensagemAdicionalResponse;
import br.com.mercadoturbo.mercadolivre.service.MsgAdicionalService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users/{user_id}/invoices/fiscal_rules/v2/aditional-messages")
public class MsgAdicionalResource {
    
    @Inject
    MsgAdicionalService service;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<MensagemAdicionalResponse> createMensagemAdicional(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String userId,
            MensagemAdicionalRequest request) {
        return service.createMensagemAdicional(authorization, userId, request);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<MensagemAdicionalResponse> updateMensagemAdicional(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String userId,
            MensagemAdicionalRequest request) {
        return service.updateMensagemAdicional(authorization, userId, request);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<MensagemAdicionalResponse>> getMensagemAdicional(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String userId) {
        return service.getMensagemAdicional(authorization, userId);
    }

    @DELETE
    @Path("/{message_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Void> deleteMensagemAdicional(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String userId,
            @PathParam("message_id") Integer messageId,
            @HeaderParam("caller.id") String callerId) {
        return service.deleteMensagemAdicional(authorization, userId, messageId, callerId);
    }
}
