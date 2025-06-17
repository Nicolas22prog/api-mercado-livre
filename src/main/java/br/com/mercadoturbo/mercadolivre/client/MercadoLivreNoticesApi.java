package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.dto.NoticesResponse;
import br.com.mercadoturbo.mercadolivre.client.apiexception.MercadoLivreExceptionMapper;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/communications/notices")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreNoticesApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<NoticesResponse> getNotices(
        @HeaderParam("Authorization") String authorization,
        @QueryParam("limit") Integer limit,
        @QueryParam("offset") Integer offset
    );
}
