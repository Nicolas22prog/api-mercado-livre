package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AutomaticPricingRequest;
import br.com.mercadoturbo.mercadolivre.dto.AutomaticPricingResponse;
import br.com.mercadoturbo.mercadolivre.dto.PriceAutomationResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/pricing-automation/items/{item_id}")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreAutomaticPricingApi {

    
    
    @GET
    @Path("/rules")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AutomaticPricingResponse> getRules(
        @HeaderParam("Authorization")String authorization,
        @PathParam("item_id")String item_id);
    
    @POST
    @Path("/automation")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PriceAutomationResponse> postAutomation(
        @HeaderParam("Authorization")String authorization,
        @PathParam("item_id")String item_id,
        AutomaticPricingRequest request);
}
