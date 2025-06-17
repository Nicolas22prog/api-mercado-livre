package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreQuestionsApi;
import br.com.mercadoturbo.mercadolivre.dto.AllQuestionsResponse;

import br.com.mercadoturbo.mercadolivre.dto.QuestionsResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@ApplicationScoped
public class QuestionsService implements Serializable{

    private static final Logger LOG = Logger.getLogger(QuestionsService.class);
    
    @Inject
    @RestClient
    MercadoLivreQuestionsApi questions;
    
        public Uni<QuestionsResponse> fetchQuestions(String accessToken,String item_id, Integer limit) {
        return questions.getQuestions(accessToken,item_id,limit);
            
        } 
           

        public Uni<QuestionsResponse.QuestionDTO> fetchDetail(String accessToken,Long question_id){
            return questions.getDetail(accessToken, question_id);
        }
        
        public Uni<AllQuestionsResponse> fetchAllQuestions(String acessToken){
            return questions.getAllQuestions(acessToken);
        }
    }

