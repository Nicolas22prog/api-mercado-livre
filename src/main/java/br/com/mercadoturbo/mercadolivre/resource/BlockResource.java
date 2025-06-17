package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.BlockResponse;
import br.com.mercadoturbo.mercadolivre.service.BlockService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/block-api/search/users/{user_id}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class BlockResource implements Serializable{

    @Inject
    BlockService service;
    
    @GET
    public Uni<BlockResponse> getBlocks(
                @HeaderParam("Authorization")String authorization,
                @PathParam("user_id")Long user_id,
                @QueryParam("type")@DefaultValue("blocked_by_questions")String type){
        return service.fetchBlocks(authorization, user_id, type);
    }
    
}
