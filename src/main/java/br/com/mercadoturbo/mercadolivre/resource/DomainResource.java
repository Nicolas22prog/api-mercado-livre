package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.DomainResponse;
import br.com.mercadoturbo.mercadolivre.dto.MedidasRequest;
import br.com.mercadoturbo.mercadolivre.service.DomainService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/domains")
public class DomainResource {
    
    @Inject
    DomainService   service;

    @GET
    @Path("/{domain_id}/technical_specs")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<DomainResponse> getTechSpecs(
            @HeaderParam("Authorization") String authorization,
            @PathParam("domain_id") String domainId) {
        return service.getTechSpecs(authorization, domainId);
    }

    @POST
    @Path("/{domain_id}/technical_specs")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<DomainResponse> postTechSpecs(
            @HeaderParam("Authorization") String authorization,
            @PathParam("domain_id") String domain_id,
            @QueryParam("section") String section,
            MedidasRequest request){
                return service.postTechSpecs(authorization, domain_id, section ,request);
            }
}
