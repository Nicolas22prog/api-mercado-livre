package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;
import java.util.List;

import br.com.mercadoturbo.mercadolivre.dto.ClaimByIdResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimDetailResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimMessagesResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimReasonResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimsResponse;
import br.com.mercadoturbo.mercadolivre.dto.DisputeResponse;
import br.com.mercadoturbo.mercadolivre.dto.FileAttachmentResponse;
import br.com.mercadoturbo.mercadolivre.dto.GetFileResponse;
import br.com.mercadoturbo.mercadolivre.dto.ImagemUploadForm;
import br.com.mercadoturbo.mercadolivre.dto.SendMessageRequest;
import br.com.mercadoturbo.mercadolivre.service.ClaimService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
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
public class ClaimResource implements Serializable{
    
    @Inject
    ClaimService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{claim_id}")
    public Uni<ClaimByIdResponse> getClaimDetails(
        @HeaderParam("Authorization") String accessToken,
        @PathParam("claim_id") String claimId
    ) {
        return service.fetchClaimById(accessToken, claimId);
    }


    @GET
    @Path("/{claim_id}/detail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ClaimDetailResponse> getClaimDetail(
        @HeaderParam("Authorization") String accessToken,
        @PathParam("claim_id") String claimId
    ) {
        return service.fetchClaimDetail(accessToken, claimId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ClaimsResponse> getClaims(
        @HeaderParam("Authorization") String accessToken,
        @QueryParam("status") String status,
        @QueryParam("stage") String stage,
        @QueryParam("sort") String sort,
        @QueryParam("offset") Integer offset,
        @QueryParam("limit") Integer limit
    ) {
        return service.fetchClaims(accessToken, status, stage, sort, offset, limit);
    }

    @GET
    @Path("/reasons/{reason_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ClaimReasonResponse> getClaimReason(
        @HeaderParam("Authorization") String accessToken,
        @PathParam("reason_id") String reasonId
    ) {
        return service.fetchClaimReason(accessToken, reasonId);
    }

    @GET
    @Path("/{claim_id}/actions-history")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<ClaimHistoryResponse.ActionItem>> getClaimActionHistory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    ){
        return service.fetchClaimActionHistory(authorization, claimId);
    }

     @GET
    @Path("/{claim_id}/status-history")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<ClaimHistoryResponse.HistoryItem>> getClaimStatusHistory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    ) {
        return service.fetchClaimStatusHistory(authorization, claimId); 
    }

     @GET
    @Path("/{claim_id}/affects-reputation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ClaimHistoryResponse> getClaimReputation(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    ){
        return service.fetchReputation(authorization, claimId);
    }

      @GET
    @Path("/{claim_id}/messages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<ClaimMessagesResponse>> getClaimMessages(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    ){
        return service.fetchClaimMessages(authorization, claimId);
    }

    @POST
    @Path("/{claim_id}/attachments")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Uni<FileAttachmentResponse> postAttachment(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId,
        ImagemUploadForm request
    ){
        return service.sendAttachment(authorization, claimId, request);
    }

    @POST
    @Path("/{claim_id}/actions/send-message")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<String> postMessage(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id,
        SendMessageRequest request
    ){
        return service.sendMessage(authorization, claim_id, request);

    }

    @GET
    @Path("/{claim_id}/attachments/{attachment_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<GetFileResponse> getFileResponse(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id,
        @PathParam("attachemnte_id") String attachment_id
    ) {
        return service.fetchFileResponse(authorization, claim_id, attachment_id);
    }

        @POST
    @Path("/{claim_id}/actions/open-dispute")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<DisputeResponse> postDisput(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id
    ) {
        return service.sendDispute(authorization, claim_id);
    }

    @GET
    @Path("/{claim_id}/expected-resolutions")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<ClaimHistoryResponse.ActionItem>> getResolutions(
                @HeaderParam("Authorization") String authorization,
            @PathParam("claim_id")String claim_id){
            return service.fetchResolution(authorization, claim_id);
            }
}
