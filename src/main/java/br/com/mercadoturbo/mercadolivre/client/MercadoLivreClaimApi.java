package br.com.mercadoturbo.mercadolivre.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.ClaimByIdResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimDetailResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimMessagesResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimReasonResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimsResponse;
import br.com.mercadoturbo.mercadolivre.dto.FileAttachmentResponse;
import br.com.mercadoturbo.mercadolivre.dto.ImagemUploadForm;
import br.com.mercadoturbo.mercadolivre.dto.SendMessageRequest;
import br.com.mercadoturbo.mercadolivre.resource.ClaimHistoryResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/post-purchase/v1/claims")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreClaimApi {
    
    @GET
    @Path("/{claim_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimByIdResponse> getClaimById(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @GET
    @Path("/{claim_id}/detail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimDetailResponse> getClaimDetail(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );


    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimsResponse> getClaims(
        @HeaderParam("Authorization") String authorization,
        @QueryParam("status") String status,
        @QueryParam("stage") String stage,
        @QueryParam("sort") String sort,
        @QueryParam("offset") Integer offset,
        @QueryParam("limit") Integer limit
    );

    @GET
    @Path("/reasons/{reason_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimReasonResponse> getClaimReason(
        @HeaderParam("Authorization") String authorization,
       
        @PathParam("reason_id") String reasonId
    );


    @GET
    @Path("/{claim_id}/actions-history")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<ClaimHistoryResponse.ActionItem>> getClaimActionHistory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @GET
    @Path("/{claim_id}/status-history")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<ClaimHistoryResponse.HistoryItem>> getClaimStatusHistory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

     @GET
    @Path("/{claim_id}/affects-reputation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimHistoryResponse> getClaimReputation(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @GET
    @Path("/{claim_id}/messages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<ClaimMessagesResponse>> getClaimMessages(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @POST
    @Path("/{claim_id}/attachments")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<FileAttachmentResponse> postAttachment(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId,
        ImagemUploadForm request
    );

    @POST
    @Path("/{claim_id}/actions/send-message")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<String> postMessage(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id,
        SendMessageRequest request
    );
}
