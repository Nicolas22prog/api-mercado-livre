package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.AttributesConditionalRequest;
import br.com.mercadoturbo.mercadolivre.dto.AttributesConditionalResponse;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import br.com.mercadoturbo.mercadolivre.dto.TechinicalSpecsResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/categories")
@RegisterRestClient(configKey="mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreAttributesApi {
 @POST
    @Path("/{category_id}/attributes/conditional")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AttributesConditionalResponse> postConditional(
        @HeaderParam("Authorization") String authorization,
        @PathParam("category_id") String category_id,
        AttributesConditionalRequest request
    );


    @GET
    @Path("/{category_id}/attributes")
    Uni<List<AttributesResponse>> getAttributes(
        @HeaderParam("Authorization") String authorization,
        @PathParam("category_id") String category_id
    );

    @GET
    @Path("/{category_id}/technical_specs/input")
    Uni<TechinicalSpecsResponse> getTechInput(
        @HeaderParam("Authorization") String authorization,
        @PathParam("category_id") String category_id
    );

    @GET
    @Path("/{category_id}/technical_specs/output")
    Uni<TechinicalSpecsResponse> getTechOutput(
        @HeaderParam("Authorization") String authorization,
        @PathParam("category_id") String category_id
    );
}
