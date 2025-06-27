package br.com.mercadoturbo.mercadolivre.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.dto.BrandMetric;
import br.com.mercadoturbo.mercadolivre.dto.KnownAttributesRequest;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/catalog_domains/{domain_id}/attributes/{attribute_id}/top_values")
@RegisterRestClient(configKey = "mercado-livre-api")
public interface MercadoLivreBrandApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<BrandMetric>> postAttribute(
            @HeaderParam("Authorization")String authorization,
            @PathParam("domain_id") String domain_id,
            @PathParam("attribute_id")String attribute_id,
             KnownAttributesRequest knownAttributesRequest
            );

            
}
