package br.com.mercadoturbo.mercadolivre.resource;

import io.smallrye.common.annotation.Blocking;

import br.com.mercadoturbo.mercadolivre.dto.ImageUploadResponse;
import br.com.mercadoturbo.mercadolivre.dto.ImagemUploadForm;
import br.com.mercadoturbo.mercadolivre.service.ImageUploadService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/pictures/items/upload")
public class ImagemUploadResource {

    @Inject
    ImageUploadService service;
    
    @POST
    @Blocking
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<ImageUploadResponse> postImage(
            @HeaderParam("Authorization")String authorization,
            ImagemUploadForm form){
     
        return service.sendImage(authorization, form);
    }
}
