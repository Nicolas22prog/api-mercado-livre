package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.TaxMessageRequest;
import br.com.mercadoturbo.mercadolivre.dto.TaxMessageResponse;
import br.com.mercadoturbo.mercadolivre.dto.TaxesResponse;
import br.com.mercadoturbo.mercadolivre.service.TaxService;
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
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/users/{user_id}/invoices/tax_rules")
public class TaxesResource {


    @Inject
    TaxService taxService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TaxesResponse> getTaxes(
        @HeaderParam("Authorization") String authorization,
        @PathParam("user_id") String user_id
    ){
        return taxService.fetchTaxes(authorization, user_id);
    }

    @POST
    @Path("/messages")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TaxMessageResponse> postTaxes(
        @HeaderParam("Authorization") String authorization,
        @PathParam("user_id") String user_id,
        TaxMessageRequest request
    ){
        return taxService.sendTaxMessage(authorization, user_id, request);
    }

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<TaxesResponse> getTaxMessages(
            @HeaderParam("Authorization") String authorization,
            
            @PathParam("user_id") String user_id,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ){
        return taxService.fetchTaxesMessages(authorization, user_id,
                limit, offset);
    }

     @GET
    @Path("/messages/{message_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TaxMessageResponse> getTaxMessageById(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("message_id") Long message_id
    ){
        return taxService.fetchTaxesMessagesById(authorization, user_id, message_id);
    }

    @PUT
    @Path("/messages/{message_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<TaxMessageResponse> putTaxMessage(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("message_id") Long message_id,
            TaxMessageRequest request
    ){
        return taxService.updateTaxMessage(authorization, user_id, message_id, request);
    }

    @DELETE
    @Path("/messages/{message_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TaxMessageResponse> deleteTaxMessage(
            @HeaderParam("Authorization") String authorization,
            @PathParam("user_id") String user_id,
            @PathParam("message_id") Long message_id
    ){
        return taxService.deleteTaxMessage(authorization, user_id, message_id);
    }
}
