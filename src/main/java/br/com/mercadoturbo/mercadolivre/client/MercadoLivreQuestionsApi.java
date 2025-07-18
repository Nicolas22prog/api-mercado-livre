package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AllQuestionsResponse;
import br.com.mercadoturbo.mercadolivre.dto.QuestionsResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreQuestionsApi{


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/questions/search")
    Uni<QuestionsResponse> getQuestions(
        @HeaderParam("Authorization") String authorization,
        @QueryParam("item_id") String item_id,
        @QueryParam("limit") @DefaultValue("50") int limit);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/questions/{question_id}")
    Uni<QuestionsResponse.QuestionDTO> getDetail(
                @HeaderParam("Authorization") String authorization,
                @PathParam("question_id")Long question_id);
    
    @GET
    @Path("/my/received_questions/search")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AllQuestionsResponse> getAllQuestions(
           @HeaderParam("Authorization")String authorization );

}
    

