package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.dto.LinkRequest;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/items/{item_id}/pictures")
@RegisterRestClient(configKey = "mercado-livre-api")

public interface MercadoLivreVincularApi {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Uni<LinkRequest> postVincular(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            LinkRequest request);
}
