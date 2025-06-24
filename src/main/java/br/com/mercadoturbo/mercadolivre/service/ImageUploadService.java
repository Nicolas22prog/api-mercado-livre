package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreUploadApi;
import br.com.mercadoturbo.mercadolivre.dto.ImageUploadResponse;
import br.com.mercadoturbo.mercadolivre.dto.ImagemUploadForm;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ImageUploadService {

    @Inject
    @RestClient
    MercadoLivreUploadApi upload;
    
    public Uni<ImageUploadResponse> sendImage(String accessToken, ImagemUploadForm form){       
        return upload.postImage(accessToken, form);
    }
}
