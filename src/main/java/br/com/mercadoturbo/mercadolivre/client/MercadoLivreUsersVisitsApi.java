package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.GenericVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.UserVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/users/{user_id}")
@RegisterRestClient(configKey="mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreUsersVisitsApi {

    @GET
    @Path("/items_visits/time_window")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<VisitsResponse> getVisits(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")Long user_id,
            @QueryParam("last")Integer last,
            @QueryParam("unit")String unit); // define a unidade de tempo, valor disponivel no momento ["day"]
    
    @GET
    @Path("/items_visits")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<UserVisitsResponse> getUserVisits(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")Long user_id,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to);
    
    @GET
    @Path("/contacts/questions")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<GenericVisitsResponse> getUserQuestions( //Retorna o total dee perguntas em um periodo de tempo
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")Long user_id,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to);
   
}
