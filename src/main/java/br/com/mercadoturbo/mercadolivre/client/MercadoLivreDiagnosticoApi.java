package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.ImageDiagRequest;
import br.com.mercadoturbo.mercadolivre.dto.ImageDiagResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/moderations/pictures/diagnostic")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreDiagnosticoApi {
        
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Uni<ImageDiagResponse> postDiag(
            @HeaderParam("Authorization")String authorization,
            ImageDiagRequest request);
}
