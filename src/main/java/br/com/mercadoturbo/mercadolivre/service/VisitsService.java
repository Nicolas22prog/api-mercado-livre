package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsVisitsApi;
import br.com.mercadoturbo.mercadolivre.client.MercadoLivreUsersVisitsApi;
import br.com.mercadoturbo.mercadolivre.dto.GenericVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsTimeWindowResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class VisitsService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreUsersVisitsApi usersVisits;
    
    @Inject
    @RestClient
    MercadoLivreItemsVisitsApi itemsVisits;
    
    
    public Uni<VisitsTimeWindowResponse> fetchVisitsTimeWindow(String accessToken, Long user_id, Integer last, String unit){
        return usersVisits.getVisits(accessToken, user_id, last, unit);
    }

    public Uni<VisitsResponse> fetchUserVisits(String accessToken, Long user_id, String date_from, String date_to){
        return usersVisits.getUserVisits(accessToken, user_id, date_from, date_to);
    }
    
    public Uni<GenericVisitsResponse> fetchUserQuestions(String accessToken, Long user_id, String date_from, String date_to){
        return usersVisits.getUserQuestions(accessToken, user_id, date_from, date_to);
    }
    
    public Uni<GenericVisitsResponse> fetchItemsQuestions(String accessToken, String item_id, String date_from, String date_to){
        return itemsVisits.getItemsVisits(accessToken, item_id, date_from, date_to);
    }
    
    public Uni<VisitsTimeWindowResponse> fetchItemsQuestionsTW(String accessToken, String item_id, Integer last, String unit)
    {
        return itemsVisits.getItemsTimeWindowVisits(accessToken,item_id, last, unit);
    }
    
    public Uni<VisitsTimeWindowResponse> fetchUserQuestionsTW(String accessToken, Long user_id, Integer last, String unit){
        return usersVisits.getUserQuestionsTW(accessToken, user_id, last, unit);
    }
    
    public Uni<VisitsResponse> fetchMultiItemsVisits(String accessToken, String ids, String date_from, String date_to){
        return itemsVisits.getMultiItemsVisits(accessToken, ids, date_from, date_to);
    }
    
    public Uni<VisitsTimeWindowResponse> fetchMultiItemsTW(String accessToken, String ids, Integer last, String unit){
        return itemsVisits.getMultItemsTW(accessToken, ids, last, unit);
    }
}
