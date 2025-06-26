package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;
import java.util.List;

import br.com.mercadoturbo.mercadolivre.dto.BrandMetric;
import br.com.mercadoturbo.mercadolivre.dto.KnownAttributesRequest;
import br.com.mercadoturbo.mercadolivre.service.BrandService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/catalog_domains/{domain_id}/attributes/{attribute_id}/top_values")
public class BrandResource implements Serializable{
        
    
    @Inject
    BrandService service;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<BrandMetric>> postAttribute(
            @HeaderParam("Authorization")String authorization,
            @PathParam("domain_id") String domain_id,
            @PathParam("attribute_id")String attribute_id,
            KnownAttributesRequest request
            ){
        return service.sendAttributes(authorization, domain_id, attribute_id, request);
    }
}
