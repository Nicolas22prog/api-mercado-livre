package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreBlockApi;
import br.com.mercadoturbo.mercadolivre.dto.BlockResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BlockService implements Serializable{

    
    @Inject
    @RestClient
    MercadoLivreBlockApi block;
    
    
    public Uni<BlockResponse> fetchBlocks(String acessToken, Long user_id, String type){
        return block.getBlocks(acessToken, user_id, type);
    }
}
