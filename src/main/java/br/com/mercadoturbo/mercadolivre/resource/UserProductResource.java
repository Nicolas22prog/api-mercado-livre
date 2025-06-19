package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.UserProductResponse;
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
    

}
