package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreFeedBackApi;
import br.com.mercadoturbo.mercadolivre.dto.FeedbackRequest;
import br.com.mercadoturbo.mercadolivre.dto.FeedbackResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FeedbackService implements Serializable {
    
    @Inject
    @RestClient
    MercadoLivreFeedBackApi feedback;
    
    public Uni<FeedbackResponse> fetchFeedback(String accessToken, long order_id){
        return feedback.getFeedback(accessToken, order_id);
    }

    public Uni<FeedbackResponse.Sale> sendFeedback(String accessToken,String order_id, FeedbackRequest request){
        return feedback.postFeedback(accessToken, order_id ,request);
    }
}
