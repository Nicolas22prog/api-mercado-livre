package br.com.mercadoturbo.mercadolivre.resource;


import br.com.mercadoturbo.mercadolivre.dto.AllQuestionsResponse;
import br.com.mercadoturbo.mercadolivre.dto.QuestionsResponse;
import br.com.mercadoturbo.mercadolivre.service.QuestionsService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestonsResource implements Serializable{

    @Inject
    QuestionsService service;    
    
    @GET
    @Path("/search")
    public Uni<QuestionsResponse> getQuestions(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("item_id") String item_id,
            @QueryParam("limit") @DefaultValue("50") int limit){
        return service.fetchQuestions(authorization, item_id, limit);
    }
    
    @GET
    @Path("/{question_id}")
    public Uni<QuestionsResponse.QuestionDTO> getDetail(
                @HeaderParam("Authorization") String authorization,
                @PathParam("question_id")Long question_id){
        
        return service.fetchDetail(authorization, question_id);
    }
    
    @GET
    @Path("/my/receivide_questions/search")
    public Uni<AllQuestionsResponse> getAllQuestions(
                    @HeaderParam("Authorization") String authorization){
        return service.fetchAllQuestions(authorization);
    }
}
