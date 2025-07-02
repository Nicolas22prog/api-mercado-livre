package br.com.mercadoturbo.mercadolivre.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.TendenciasResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/trends")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreTendenciaApi {

    @GET
    @Path("/{site_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<TendenciasResponse>> getTendencias(
        @HeaderParam("Authorization") String authorization,
        @PathParam("site_id") String siteId);


    @GET
    @Path("/{site_id}/{cateogory_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<TendenciasResponse>> getTendenciasByCategory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("site_id") String siteId,
        @PathParam("cateogory_id") String categoryId);
}
