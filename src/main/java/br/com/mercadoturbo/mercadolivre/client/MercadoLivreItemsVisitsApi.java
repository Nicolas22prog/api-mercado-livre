package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.dto.GenericVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsTimeWindowResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/items/{item_id}")
@RegisterRestClient(configKey = "mercado-livre-api")
public interface MercadoLivreItemsVisitsApi {
    
    
    @GET
    @Path("/contacts/questions")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<GenericVisitsResponse> getItemsVisits(
                    @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to);
    
    @GET
    @Path("/contacts/questions/time_window")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<VisitsTimeWindowResponse> getItemsTimeWindowVisits(
                    @HeaderParam("Authorization")String authorization,
                    @PathParam("item_id")String item_id,
                    @QueryParam("last")Integer last,
                    @QueryParam("unit")String unit);
}
