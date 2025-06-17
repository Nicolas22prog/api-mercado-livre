package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.FeedbackRequest;
import br.com.mercadoturbo.mercadolivre.dto.FeedbackResponse;
import br.com.mercadoturbo.mercadolivre.service.FeedbackService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/orders/{order_id}/feedback")

public class FeedbackResource implements Serializable{
    
    @Inject
    FeedbackService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<FeedbackResponse> getFeedback(
                @HeaderParam("Authorization")String authorization,
                @PathParam("order_id")long order_id){
        return service.fetchFeedback(authorization, order_id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<FeedbackResponse.Sale>postFeedback(
                @HeaderParam("Authorization")String authorization,
                 FeedbackRequest request){
        return service.sendFeedback(authorization, request);
    }
}
