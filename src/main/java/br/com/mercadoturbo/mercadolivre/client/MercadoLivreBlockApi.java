package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.BlockResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/block-api/search/users/{user_id}")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreBlockApi {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<BlockResponse> getBlocks(
                @HeaderParam("Authorization")String authorization,
                @PathParam("user_id")Long user_id,
                @QueryParam("type")@DefaultValue("blocked_by_questions")String type);
}
