package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.CatalogRequest;
import br.com.mercadoturbo.mercadolivre.dto.CatalogResponse;
import br.com.mercadoturbo.mercadolivre.dto.DomainsTrackResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/catalog")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface  MercadoLivreCatalogApi {
    
    @POST
    @Path("/charts/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<CatalogResponse> postCatalogSearch(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            CatalogRequest request);

    @POST
    @Path("/charts/domains/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<DomainsTrackResponse> postDomainSearch(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            CatalogRequest request);
            
}
