package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.SellingAddressUpdate;
import br.com.mercadoturbo.mercadolivre.dto.UserProductResponse;
import br.com.mercadoturbo.mercadolivre.dto.WareHouseResponse;
import br.com.mercadoturbo.mercadolivre.dto.WareHouseUpdate;
import br.com.mercadoturbo.mercadolivre.service.UserProductService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/user-products/{user_product_id}")
public class UserProductResource implements Serializable{
    
    @Inject
    UserProductService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<UserProductResponse> getUserProduct(
                @HeaderParam("Authorization")String authorization,
                @PathParam("user_product_id")String user_product_id){
        return service.fetchUserProduct(authorization, user_product_id);
    }
    
    @PUT
     @Path("/type/seller_warehouse")
     @Produces(MediaType.APPLICATION_JSON)
     public Uni<WareHouseResponse> updateStockWH(
            @HeaderParam("Authorization")String authorization,
             @PathParam("user_product_id")String user_product_id,
             WareHouseUpdate update){
         return service.updateStockWH(authorization, user_product_id, update);
     }
     
     @PUT
     @Path("/type/selling_address")
     @Produces(MediaType.APPLICATION_JSON)
     public Uni<SellingAddressUpdate> updateStockWH(
            @HeaderParam("Authorization")String authorization,
             @PathParam("user_product_id")String user_product_id,
             SellingAddressUpdate update){
         return service.updateStockSA(authorization, user_product_id, update);}
}
