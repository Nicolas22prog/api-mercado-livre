package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AnswerRequest;
import br.com.mercadoturbo.mercadolivre.dto.AnswerResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/answers")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreAnswersApi {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<AnswerResponse> postAnswer(
            @HeaderParam("Authorization")String authorization,
            AnswerRequest request);

}
