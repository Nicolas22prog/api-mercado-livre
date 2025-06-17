package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.AnswerRequest;
import br.com.mercadoturbo.mercadolivre.dto.AnswerResponse;
import br.com.mercadoturbo.mercadolivre.service.AnswerService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/answers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnswerResource implements Serializable{

    @Inject
    AnswerService service;
    
    @POST
    public Uni<AnswerResponse> postAnswer(
    @HeaderParam("Authorization") String authorization,
            AnswerRequest response){        
        return service.sendAnswer(authorization, response);        
    }
}
