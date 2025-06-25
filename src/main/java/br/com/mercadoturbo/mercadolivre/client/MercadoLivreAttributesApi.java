package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/categories/{categoty_id}/attributes")
@RegisterRestClient(configKey="mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreAttributesApi {

    @GET
        @Produces(MediaType.APPLICATION_JSON)
 
    Uni<AttributesResponse> getAttributes(
            @HeaderParam("Authorization") String authorization,
            @PathParam("category_id")String category_id);
}
