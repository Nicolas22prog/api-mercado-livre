package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AlicotaRequest;
import br.com.mercadoturbo.mercadolivre.dto.AlicotaResponse;
import br.com.mercadoturbo.mercadolivre.dto.TaxMessageRequest;
import br.com.mercadoturbo.mercadolivre.dto.TaxMessageResponse;
import br.com.mercadoturbo.mercadolivre.dto.TaxesResponse;
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

@Path("/users/{user_id}//invoices/tax_rules")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreTaxesApi {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<TaxesResponse> getTaxes(
            @jakarta.ws.rs.HeaderParam("Authorization") String authorization,
            @jakarta.ws.rs.PathParam("user_id") String user_id
    );

    @POST
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<TaxMessageResponse> postTaxes(
            @jakarta.ws.rs.HeaderParam("Authorization") String authorization,
            @jakarta.ws.rs.PathParam("user_id") String user_id,
            TaxMessageRequest request
    );

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<TaxesResponse> getTaxMessages(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    );

    @GET
    @Path("/messages/{message_id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<TaxMessageResponse> getTaxMessageById(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("message_id") Long message_id
    );

    @PUT
    @Path("/messages/{message_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<TaxMessageResponse> putTaxMessage(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("message_id") Long message_id,
            TaxMessageRequest request
    );

    @DELETE
    @Path("/messages/{message_id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<TaxMessageResponse> deleteTaxMessage(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("message_id") Long message_id
    );

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<AlicotaResponse> postAlicota(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            AlicotaRequest request
    );
}
