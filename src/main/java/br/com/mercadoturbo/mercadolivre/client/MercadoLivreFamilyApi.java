package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.FamilyResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/sites/{site_id}/user-products-families/{family_id}")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreFamilyApi {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<FamilyResponse> getFamilyItems(
            @HeaderParam("Authorization")String authorization,
            @PathParam("site_id") String site_id,
            @PathParam("family_id")Long family_id);

}
