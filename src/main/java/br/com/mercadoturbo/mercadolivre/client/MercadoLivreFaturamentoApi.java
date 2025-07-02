package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.dto.FaturamentoResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/billing/integration")
@RegisterRestClient(configKey = "mercado-livre-api")
public interface MercadoLivreFaturamentoApi {
    
    @GET
    @Path("/monthly/periods")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<FaturamentoResponse> getFaturamentoMensal(
        @HeaderParam("Authorization") String authorization,
        @QueryParam("group") String group,
        @QueryParam("document_type") String documentType,
        @QueryParam("offset") Integer offset,
        @QueryParam("limit") Integer limit
    );

    @GET
    @Path("/periods/key/{key}/documents")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<FaturamentoResponse> getFaturamentoMensalByKey(
        @HeaderParam("Authorization") String authorization,
        @PathParam("key") String key,
        @QueryParam("group") String group,
        @QueryParam("document_type") String documentType,
        @QueryParam("offset") Integer offset,
        @QueryParam("limit") Integer limit
    );
}
