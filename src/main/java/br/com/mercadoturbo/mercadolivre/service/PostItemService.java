package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsApi;
import br.com.mercadoturbo.mercadolivre.dto.PostItemRequest;
import br.com.mercadoturbo.mercadolivre.dto.PostItemResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PostItemService implements Serializable{

    @Inject
    @RestClient
    MercadoLivreItemsApi post;
    
    public Uni<PostItemResponse> sendItem(String accessToken, PostItemRequest request){
        return post.postItem(accessToken, request);
    }
    
    public Uni<PostItemResponse> updateItem(String accessTokne,Long item_id ,PostItemRequest request){
        return post.putItem(accessTokne, item_id,request);
    }
}
