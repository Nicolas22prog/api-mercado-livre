package br.com.mercadoturbo.mercadolivre.client;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.SellingAddressUpdate;
import br.com.mercadoturbo.mercadolivre.dto.StockResponse;
import br.com.mercadoturbo.mercadolivre.dto.UserProductResponse;
import br.com.mercadoturbo.mercadolivre.dto.WareHouseResponse;
import br.com.mercadoturbo.mercadolivre.dto.WareHouseUpdate;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/user-products/{user_product_id}")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreUserProductApi {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<UserProductResponse> getUserProduct(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_product_id")String user_product_id);
    
     @GET
     @Path("/stock")
     @Produces(MediaType.APPLICATION_JSON)
     Uni<StockResponse> getStock(
            @HeaderParam("Authorization")String authorization,
            @PathParam("user_product_id")String user_product_id);
     
     @PUT
     @Path("/type/seller_warehouse")
     @Produces(MediaType.APPLICATION_JSON)
     Uni<WareHouseResponse> updateStockWH(
            @HeaderParam("Authorization")String authorization,
             @PathParam("user_product_id")String user_product_id,
              WareHouseUpdate update);
     
     @PUT
     @Path("/type/selling_address")
     @Produces(MediaType.APPLICATION_JSON)
     Uni<SellingAddressUpdate> updateStockSA(
            @HeaderParam("Authorization")String authorization,
             @PathParam("user_product_id")String user_product_id,
              SellingAddressUpdate update);
}
