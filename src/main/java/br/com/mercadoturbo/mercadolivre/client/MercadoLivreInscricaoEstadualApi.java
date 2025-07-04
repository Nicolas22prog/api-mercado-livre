package br.com.mercadoturbo.mercadolivre.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.RegistroEstadualRequest;
import br.com.mercadoturbo.mercadolivre.dto.RegistroEstadualResponse;
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
import jakarta.ws.rs.core.MediaType;

@Path("/users/{user_id}/invoices/state_registry/{cnpj}/{state}")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface  MercadoLivreInscricaoEstadualApi {

    @POST
    @Path("/{state}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<RegistroEstadualResponse> postRegistroEstadual(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("cnpj") String cnpj,
            @PathParam("state") String state,
            RegistroEstadualRequest request);
    
    @PUT
    @Path("/{state}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<RegistroEstadualResponse> putRegistroEstadual(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("cnpj") String cnpj,
            @PathParam("state") String state,
            RegistroEstadualRequest request);
    
    @DELETE
    @Path("/{state}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<RegistroEstadualResponse> deleteRegistroEstadual(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("cnpj") String cnpj,
            @PathParam("state") String state);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<RegistroEstadualResponse>> getRegistroEstadual(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("cnpj") String cnpj);

    @PUT
    @Path("/batch")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<RegistroEstadualResponse> putRegistroEstadualBatch(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("cnpj") String cnpj,
            RegistroEstadualRequest request);
}
