package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.ImageUploadResponse;
import br.com.mercadoturbo.mercadolivre.dto.ImagemUploadForm;
import br.com.mercadoturbo.mercadolivre.service.ImageUploadService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.File;

@Path("/pictures/items/upload")
public class ImagemUploadResource {

    @Inject
    ImageUploadService service;
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<ImageUploadResponse> postImage(
            @HeaderParam("Authorization")String authorization,
            File imagem){
        
        ImagemUploadForm form = new ImagemUploadForm();
        form.file=imagem;
        return service.sendImage(authorization, form);
    }
}
