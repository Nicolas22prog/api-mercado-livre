package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.PriceForSellingResponse;
import br.com.mercadoturbo.mercadolivre.service.PriceForSellingService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/sites/{site_id}/listing_prices")
public class PriceForSellingResource {

    @Inject
    PriceForSellingService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<PriceForSellingResponse>> getPrices(
            @HeaderParam("Authorization")String authorization,
            @PathParam("site_id")String site_id,
            @QueryParam("category_id")String category_id,
            @QueryParam("price")Integer price,
            @QueryParam("listing_type_id")String listing_type_id,
            @QueryParam("currency_id")String currency_id,
            @QueryParam("tags")String tags){
        return service.fetchPrice(authorization, site_id, category_id, price, listing_type_id, currency_id, tags);
    }
}
