package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.GenericVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.UserVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsResponse;
import br.com.mercadoturbo.mercadolivre.service.VisitsService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;



@Path("/visits")
public class VisitsResource implements Serializable{

    
    @Inject
    VisitsService service;
    
    @GET
    @Path("/users/{user_id}/items_visits/time_window")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<VisitsResponse> getVisits(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")Long user_id,
            @QueryParam("last")Integer last, // max 149 
            @QueryParam("unit")String unit)/*Unidade de tempo, valor disponivel no momento [day]*/ {
            return service.fetchVisits(authorization, user_id, last, unit);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users/{user_id}/items_visits")
    public Uni<UserVisitsResponse> getUserVisits(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")Long user_id,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to){
        System.out.println(date_from);
        System.out.println(date_to);
        return service.fetchUserVisits(authorization, user_id, date_from, date_to);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users/{user_id}/contacts/questions")
    public Uni<GenericVisitsResponse> getUserQuestions(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")Long user_id,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to){
        System.out.println(date_from);
        System.out.println(date_to);
        return service.fetchUserQuestions(authorization, user_id, date_from, date_to);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/items/{item_id}/contacts/questions")
    public Uni<GenericVisitsResponse> getItemsQuestions(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to){
        System.out.println(date_from);
        System.out.println(date_to);
        return service.fetchItemsQuestions(authorization, item_id, date_from, date_to);
    }
}
