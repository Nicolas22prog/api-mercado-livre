package br.com.mercadoturbo.mercadolivre.client;


import br.com.mercadoturbo.mercadolivre.dto.MultigetResponse;
import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/items")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreMultigetApi {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)           
    Uni<List<MultigetResponse>> getItens(
        @HeaderParam("Authorization") String authorization,
        @QueryParam("ids") String ids,
        @QueryParam("attributes") String attributes
        
);
}
