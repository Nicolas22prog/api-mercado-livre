package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreDiagnosticoApi;
import br.com.mercadoturbo.mercadolivre.dto.ImageDiagRequest;
import br.com.mercadoturbo.mercadolivre.dto.ImageDiagResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ImageDiagService implements Serializable{
    
    
    @Inject
    @RestClient
    MercadoLivreDiagnosticoApi diagnostico;
    
    public Uni<ImageDiagResponse> sendDiag(String accessToken, ImageDiagRequest request){
        return diagnostico.postDiag(accessToken, request);
    }

}
