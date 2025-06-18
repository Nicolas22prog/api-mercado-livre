package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsVisitsApi;
import br.com.mercadoturbo.mercadolivre.client.MercadoLivreUsersVisitsApi;
import br.com.mercadoturbo.mercadolivre.dto.GenericVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.UserVisitsResponse;
import br.com.mercadoturbo.mercadolivre.dto.VisitsResponse;
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
    
    
    public Uni<VisitsResponse> fetchVisits(String accessToken, Long user_id, Integer last, String unit){
        return usersVisits.getVisits(accessToken, user_id, last, unit);
    }

    public Uni<UserVisitsResponse> fetchUserVisits(String accessToken, Long user_id, String date_from, String date_to){
        return usersVisits.getUserVisits(accessToken, user_id, date_from, date_to);
    }
    
    public Uni<GenericVisitsResponse> fetchUserQuestions(String accessToken, Long user_id, String date_from, String date_to){
        return usersVisits.getUserQuestions(accessToken, user_id, date_from, date_to);
    }
    
    public Uni<GenericVisitsResponse> fetchItemsQuestions(String accessToken, String item_id, String date_from, String date_to){
        return itemsVisits.getItemsVisits(accessToken, item_id, date_from, date_to);
    }
}
