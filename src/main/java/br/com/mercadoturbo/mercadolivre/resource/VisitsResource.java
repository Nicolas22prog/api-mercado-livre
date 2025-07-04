package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.com.mercadoturbo.mercadolivre.dto.GenericVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsTimeWindowResponse;
import br.com.mercadoturbo.mercadolivre.service.VisitsService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;



@Path("/visits")
public class VisitsResource implements Serializable{

    
    @Inject
    VisitsService service;
    
    @GET
    @Path("/users/{user_id}/items_visits/time_window")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<VisitsTimeWindowResponse> getVisitsTimeWindow(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")Long user_id,
            @QueryParam("last")Integer last, // max 149 
            @QueryParam("unit")String unit)/*Unidade de tempo, valor disponivel no momento [day]*/ {
            return service.fetchVisitsTimeWindow(authorization, user_id, last, unit);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users/{user_id}/items_visits")
    public Uni<VisitsResponse> getUserVisits(
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
    
     @GET
     @Path("/items/{item_id}/contacts/questions/time_window")
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public Uni<VisitsTimeWindowResponse> getItemsQuestionsTW(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("last")Integer last, // max 149 
            @QueryParam("unit")String unit)/*Unidade de tempo, valor disponivel no momento [day]*/ {
            return service.fetchItemsQuestionsTW(authorization, item_id, last, unit);
     }
    
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     @Path("/users/{user_id}/contacts/questions/time_window")
     public Uni<VisitsTimeWindowResponse> getUsersQuestionsTW(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_id")Long user_id,
            @QueryParam("last")Integer last, // max 149 
            @QueryParam("unit")String unit){
         return service.fetchUserQuestionsTW(authorization, user_id, last, unit);
     }
        


     @GET
     @Produces(MediaType.APPLICATION_JSON)
     @Path("/items/visits")
     public Uni<List<VisitsResponse>> getMultiItemsVisits(
             @HeaderParam("Authorization")String authorization,
            @QueryParam("ids")String ids,
            @QueryParam("date_from")String date_from,
            @QueryParam("date_to")String date_to){
         return service.fetchMultiItemsVisits(authorization, ids, date_from, date_to);
     }
     
     @GET
     @Path("/items/visits/time_window")
     @Produces(MediaType.APPLICATION_JSON)
     public Uni<VisitsTimeWindowResponse> getMultiItemsTW(
                    @HeaderParam("Authorization")String authorization,
                    @QueryParam("ids")String item_id,
                    @QueryParam("last")Integer last,
                    @QueryParam("unit")String unit){
         return service.fetchItemsQuestionsTW(authorization, item_id, last, unit);
     }


        @GET
        @Path("/items")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Uni<Map<String, Integer>> getVisitsCount(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("ids") String ids) {
            return service.fetchVisitsCount(authorization, ids);}
}
