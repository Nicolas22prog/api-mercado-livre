package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.dto.BrandMetric;
import br.com.mercadoturbo.mercadolivre.dto.KnownAttributesRequest;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/catalog_domains/{domain_id}/attributes/{attribute_id}/top_values")
@RegisterRestClient(configKey = "mercado-livre-api")
public interface MercadoLivreBrandApi {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<BrandMetric>> postAttribute(
            @HeaderParam("Authorization")String authorization,
            @PathParam("domain_id") String domain_id,
            @PathParam("attribute_id")String attribute_id,
            KnownAttributesRequest request);
}
