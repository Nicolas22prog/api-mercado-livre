package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.FamilyResponse;
import br.com.mercadoturbo.mercadolivre.service.FamilyService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("sites/{site_id}/user-products-families/{family_id}")
public class FamilyResource implements Serializable{
    
    @Inject
    FamilyService service;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<FamilyResponse> getFamilyItems(
            @HeaderParam("Authorization")String authorization,
            @PathParam("site_id")String site_id,
            @PathParam("family_id")Long family_id){
        return service.fetchFamilyItems(authorization, site_id, family_id);
    }

}
