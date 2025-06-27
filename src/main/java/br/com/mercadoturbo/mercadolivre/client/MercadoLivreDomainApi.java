package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.DomainResponse;
import br.com.mercadoturbo.mercadolivre.dto.MedidasRequest;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/domains")
@RegisterRestClient(configKey="mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface  MercadoLivreDomainApi {


    @GET
    @Path("/{domain_id}/technical_specs")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<DomainResponse> getTechSpecs(
            @HeaderParam("Authorization") String authorization,
            @PathParam("domain_id") String domain_id);


    @POST
    @Path("/{domain_id}/technical_specs")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<DomainResponse> postTechSpecs(
            @HeaderParam("Authorization") String authorization,
            @PathParam("domain_id") String domain_id,
            @QueryParam("section") String section,
            MedidasRequest request);
}
