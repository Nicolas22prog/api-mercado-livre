package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import br.com.mercadoturbo.mercadolivre.dto.TechinicalSpecsResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/categories/{category_id}")
@RegisterRestClient(configKey="mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreAttributesApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/attributes")
    Uni<List<AttributesResponse>> getAttributes(
            @HeaderParam("Authorization") String authorization,
            @PathParam("category_id")String category_id);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/technical_specs/input")
    Uni<TechinicalSpecsResponse> getTechInput(
            @HeaderParam("Authorization")String authorization,
            @PathParam("category_id")String category_id);
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/technical_specs/output")
    Uni<TechinicalSpecsResponse> getTechOutput(
            @HeaderParam("Authorization")String authorization,
            @PathParam("category_id")String category_id);
}
