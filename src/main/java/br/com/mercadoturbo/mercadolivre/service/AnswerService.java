package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreAnswersApi;
import br.com.mercadoturbo.mercadolivre.dto.AnswerRequest;
import br.com.mercadoturbo.mercadolivre.dto.AnswerResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class AnswerService implements Serializable{
    
    
    @Inject
    @RestClient
    MercadoLivreAnswersApi answer;
    
    
    public Uni<AnswerResponse> sendAnswer(String accesToken, AnswerRequest response){
        return answer.postAnswer(accesToken, response);
    }
    
}
