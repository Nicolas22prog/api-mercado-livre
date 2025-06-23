package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.FamilyResponse;
import br.com.mercadoturbo.mercadolivre.dto.MigrationRequest;
import br.com.mercadoturbo.mercadolivre.dto.MigrationStatusResponse;
import br.com.mercadoturbo.mercadolivre.service.FamilyService;
import br.com.mercadoturbo.mercadolivre.service.MigrationService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("sites/{site_id}")
public class FamilyResource implements Serializable{
    
    @Inject
    FamilyService service;
    
    @Inject
    MigrationService migration;
    
    @GET
    @Path("/user-products-families/{family_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<FamilyResponse> getFamilyItems(
            @HeaderParam("Authorization")String authorization,
            @PathParam("site_id")String site_id,
            @PathParam("family_id")Long family_id){
        return service.fetchFamilyItems(authorization, site_id, family_id);
    }
    
    @POST
    @Path("/items/user_product_listings")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<MigrationRequest> postMigration(
                @HeaderParam("Authorization")String authorization,
                @PathParam("site_id")String site_id,
                MigrationRequest request){
        return migration.postMigration(authorization, site_id, request);
}
    
    @GET
    @Path("/{item_id}/migration_live_listing")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<MigrationStatusResponse> getMigrationStatus(
                @HeaderParam("Authorization")String authorization,
                @PathParam("item_id")String item_id){
        return migration.fetchMigrationStatus(authorization, item_id);
    }
}
