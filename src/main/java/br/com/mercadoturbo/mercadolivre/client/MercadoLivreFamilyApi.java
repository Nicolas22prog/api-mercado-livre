package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.FamilyResponse;
import br.com.mercadoturbo.mercadolivre.dto.MigrationRequest;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/sites/{site_id}")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreFamilyApi {
    
    @GET // Retorna os itens de uma familia especifica
    @Path("/user-products-families/{family_id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<FamilyResponse> getFamilyItems(
            @HeaderParam("Authorization")String authorization,
            @PathParam("site_id") String site_id,
            @PathParam("family_id")Long family_id);

    
    @POST
    @Path("/items/user_products_listings")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<MigrationRequest> postMigration(
                @HeaderParam("Authorization")String authorization,
                @PathParam("site_id")String site_id,
                MigrationRequest request);
}
