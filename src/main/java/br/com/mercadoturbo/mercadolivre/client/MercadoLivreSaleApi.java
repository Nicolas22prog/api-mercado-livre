package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.PostPriceRequest;
import br.com.mercadoturbo.mercadolivre.dto.PricesResponse;
import br.com.mercadoturbo.mercadolivre.dto.SaleDTO;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("items/{item_id}")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreSaleApi {

    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sale_price")
    Uni<SaleDTO> getSale(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            @QueryParam("context")String context); //channel_marketplace, channel_mshops, (channel_proximity, mp_merchats e mp_links)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/prices")
    Uni<PricesResponse> getPrices(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id);

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/prices/standard")
    Uni<PostPriceRequest> postPrice(
            @HeaderParam("Authorization")String authorization,
            @PathParam("item_id")String item_id,
            PostPriceRequest request);
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/prices/standard/quantity")
}
