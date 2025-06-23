package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.DescriptionResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostDescriptionRequest;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/items/{item_id}/description")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreDescriptionApi {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<DescriptionResponse> getDescription(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id);
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Uni<DescriptionResponse> postDescription(
            @HeaderParam("Auhtorization")String authorization,
            @PathParam("item_id")String item_id,
            PostDescriptionRequest request);
    
    @PUT
    
    @Produces(MediaType.APPLICATION_JSON)
    Uni<DescriptionResponse> updateDescription(
            @HeaderParam("Auhtorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("api_version") @DefaultValue("2") int api_version,
            PostDescriptionRequest request);

}
