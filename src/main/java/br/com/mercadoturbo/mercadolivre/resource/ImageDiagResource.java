package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.ImageDiagRequest;
import br.com.mercadoturbo.mercadolivre.dto.ImageDiagResponse;
import br.com.mercadoturbo.mercadolivre.service.ImageDiagService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/moderations/pictures/diagnostic")
public class ImageDiagResource{

    @Inject
    ImageDiagService service;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<ImageDiagResponse> postDiag(
            @HeaderParam("Authorization")String authorization,
            ImageDiagRequest request){
        return service.sendDiag(authorization, request);
    }
}
