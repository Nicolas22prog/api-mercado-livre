package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.dto.LinkRequest;
import br.com.mercadoturbo.mercadolivre.dto.PictureUpdateRequest;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/items/{item_id}")
@RegisterRestClient(configKey = "mercado-livre-api")

public interface MercadoLivreVincularApi {

    @POST
    @Path("/pictures")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<LinkRequest> postVincular(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            LinkRequest request);
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    Uni<PictureUpdateRequest> updatePicture(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            PictureUpdateRequest request);
    
    
}
