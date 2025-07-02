package br.com.mercadoturbo.mercadolivre.client;

import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.dto.GenericVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsTimeWindowResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@RegisterRestClient(configKey = "mercado-livre-api")
public interface MercadoLivreItemsVisitsApi {
    
    
    @GET
    @Path("/items/{item_id}/contacts/questions")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<GenericVisitsResponse> getItemsVisits(
                    @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to);
    
    @GET
    @Path("/items/{item_id}/contacts/questions/time_window")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<VisitsTimeWindowResponse> getItemsTimeWindowVisits(
                    @HeaderParam("Authorization")String authorization,
                    @PathParam("item_id")String item_id,
                    @QueryParam("last")Integer last,
                    @QueryParam("unit")String unit);
    
    @GET
    @Path("/items/visits")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<VisitsResponse>> getMultiItemsVisits (
            @HeaderParam("Authorization")String authorization,
            @QueryParam("ids")String ids,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to);
    
    @GET
    @Path("/items/visits/time_window")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<VisitsTimeWindowResponse> getMultItemsTW(
                    @HeaderParam("Authorization")String authorization,
                    @QueryParam("ids")String item_id,
                    @QueryParam("last")Integer last,
                    @QueryParam("unit")String unit);
    
     @GET
     @Path("/visits/items")
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     Uni<Map<String, Integer>> getVisitsCount(
         @HeaderParam("Authorization") String authorization,
         @QueryParam("ids") String ids
     );               
}
