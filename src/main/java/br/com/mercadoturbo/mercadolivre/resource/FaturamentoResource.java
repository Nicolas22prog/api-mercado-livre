package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;

import br.com.mercadoturbo.mercadolivre.dto.FaturamentoResponse;
import br.com.mercadoturbo.mercadolivre.service.FaturamentoService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/billing/integration")
public class FaturamentoResource implements Serializable{
    @Inject
    FaturamentoService service;

    @GET
    @Path("/monthly/periods")
    public Uni<FaturamentoResponse> getFaturamentoMensal(
        @HeaderParam("Authorization") String authorization,
        @QueryParam("group") String group,
        @QueryParam("document_type") String documentType,
        @QueryParam("offset") Integer offset,
        @QueryParam("limit") Integer limit
    ) {
        return service.fetchFaturamentoMensal(authorization, group, documentType, offset, limit);
    }


    @GET
    @Path("/periods/key/{key}/documents")
    public Uni<FaturamentoResponse> getFaturamentoMensalByKey(
        @HeaderParam("Authorization") String authorization,
        @PathParam("key") String key,
        @QueryParam("group") String group,
        @QueryParam("document_type") String documentType,
        @QueryParam("offset") Integer offset,
        @QueryParam("limit") Integer limit
    ) {
        return service.fetchFaturamentoMensalByKey(authorization, key, group, documentType, offset, limit);
    }
}
