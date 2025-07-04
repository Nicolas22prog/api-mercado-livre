package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.CatalogRequest;
import br.com.mercadoturbo.mercadolivre.dto.CatalogResponse;
import br.com.mercadoturbo.mercadolivre.dto.DomainsTrackResponse;
import br.com.mercadoturbo.mercadolivre.service.CatalogService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/catalog")
public class CatalogResource implements Serializable{
    
    @Inject
    CatalogService catalogService;

    
    @POST
    @Path("/charts/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<CatalogResponse> postCatalogSearch(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            CatalogRequest request){
                return catalogService.postCatalogSearch(authorization,offset,limit ,request);
            }

    @POST
    @Path("/charts/domains/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<DomainsTrackResponse> postDomainSearch(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            CatalogRequest request){
                return catalogService.postDomainSearch(authorization,offset,limit ,request);
            }
            
}
