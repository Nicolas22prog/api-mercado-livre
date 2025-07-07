package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.PriceAutomationResponse;
import br.com.mercadoturbo.mercadolivre.dto.AutomaticPricingRequest;
import br.com.mercadoturbo.mercadolivre.dto.AutomaticPricingResponse;
import br.com.mercadoturbo.mercadolivre.service.PriceAutomationService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/pricing-automation/items/{item_id}")
public class PriceAutomationResource {
    
    
    @Inject
    PriceAutomationService service;
    
    @GET
    @Path("/rules")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<AutomaticPricingResponse> getRules(
        @HeaderParam("Authorization")String authorization,
        @PathParam("item_id")String item_id){
        return service.fetchRules(authorization, item_id);
    }
    
    @POST
    @Path("/automation")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PriceAutomationResponse> postAutomation(
        @HeaderParam("Authorization")String authorization,
        @PathParam("item_id")String item_id,
        AutomaticPricingRequest request){
        return service.sendAutomation(authorization, item_id, request);
    }
}
