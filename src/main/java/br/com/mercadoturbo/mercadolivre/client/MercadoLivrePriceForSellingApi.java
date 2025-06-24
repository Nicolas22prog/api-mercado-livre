package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.PriceForSellingResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("sites/{site_id}/listing_prices")
@RegisterRestClient(configKey="mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivrePriceForSellingApi {
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<PriceForSellingResponse>> fetchPrice(
            @HeaderParam("Authorization")String authorization,
            @PathParam("site_id")String site_id,
            @QueryParam("category_id")String category_id,
            @QueryParam("price")Integer price,
            @QueryParam("listing_type_id")String listing_type_id,
            @QueryParam("currency_id")String currency_id,
            @QueryParam("tags")String tags);
    
}
