package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.MensagemAdicionalRequest;
import br.com.mercadoturbo.mercadolivre.dto.MensagemAdicionalResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("users/{user_id}/invoices/fiscal_rules/v2/additional-messages")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreMsgAdicionalApi {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<MensagemAdicionalResponse> createMensagemAdicional(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String userId,
            MensagemAdicionalRequest request);


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<MensagemAdicionalResponse> updateMensagemAdicional(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String userId,
            MensagemAdicionalRequest request); 
            
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<MensagemAdicionalResponse> getMensagemAdicional(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String userId);

    @DELETE
    @Path("{message_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Void> deleteMensagemAdicional(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String userId,
            @PathParam("message_id") Integer messageId,
            @QueryParam("caller.id")String callerId);
}
