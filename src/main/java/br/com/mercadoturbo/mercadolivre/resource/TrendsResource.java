package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;
import java.util.List;

import br.com.mercadoturbo.mercadolivre.dto.TendenciasResponse;
import br.com.mercadoturbo.mercadolivre.service.TrendsService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/trends")
public class TrendsResource implements Serializable {
    @Inject
    TrendsService service;
    
    
    @GET
    @Path("/{siteId}")
    public Uni<List<TendenciasResponse>> getTendencias(
        @HeaderParam("Authorization") String authorization,
        @PathParam("siteId") String siteId
    ) {
        return service.fetchTendencias(authorization, siteId);
    }

    @GET
    @Path("/{siteId}/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<TendenciasResponse>> getTendenciasByCategory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("siteId") String siteId,
        @PathParam("categoryId") String categoryId
    ) {
        return service.fetchTendenciasByCategory(authorization, siteId, categoryId);
    }
}
