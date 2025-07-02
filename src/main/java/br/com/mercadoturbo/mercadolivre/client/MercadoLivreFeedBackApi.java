package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.FeedbackRequest;
import br.com.mercadoturbo.mercadolivre.dto.FeedbackResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/orders/{order_id}/feedback")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreFeedBackApi {
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<FeedbackResponse> getFeedback(
                @HeaderParam("Authorization")String authorization,
                @PathParam("order_id")long order_id);

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Uni<FeedbackResponse.Sale> postFeedback(
                @HeaderParam("Authorization")String authorization,
                @PathParam("order_id") String order_id,
                 FeedbackRequest request); 
}
