package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.dto.GenericVisitsResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/items/{item_id}/contacts/questions")
@RegisterRestClient(configKey = "mercado-livre-api")
public interface MercadoLivreItemsVisitsApi {
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<GenericVisitsResponse> getItemsVisits(
                    @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to);
}
