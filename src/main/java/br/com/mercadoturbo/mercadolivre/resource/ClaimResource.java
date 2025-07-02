package br.com.mercadoturbo.mercadolivre.resource;

import java.io.Serializable;
import java.util.List;

import br.com.mercadoturbo.mercadolivre.dto.ClaimByIdResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimDetailResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimMessagesResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimReasonResponse;
import br.com.mercadoturbo.mercadolivre.dto.ClaimsResponse;
import br.com.mercadoturbo.mercadolivre.dto.DevolucoesResponse;
import br.com.mercadoturbo.mercadolivre.dto.DisputeResponse;
import br.com.mercadoturbo.mercadolivre.dto.EvidenceRequest;
import br.com.mercadoturbo.mercadolivre.dto.EvidenceResponse;
import br.com.mercadoturbo.mercadolivre.dto.FileAttachmentResponse;
import br.com.mercadoturbo.mercadolivre.dto.GetFileResponse;
import br.com.mercadoturbo.mercadolivre.dto.ImagemUploadForm;
import br.com.mercadoturbo.mercadolivre.dto.PartialRefoundResponse;
import br.com.mercadoturbo.mercadolivre.dto.RefundRequest;
import br.com.mercadoturbo.mercadolivre.dto.RefundResponse;
import br.com.mercadoturbo.mercadolivre.dto.ReturnReviewFailResponse;
import br.com.mercadoturbo.mercadolivre.dto.ReturnReviewOkResponse;
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

@Path("/post-purchase/v1")
public class ClaimResource implements Serializable{
    
    @Inject
    ClaimService service;

  
    @GET
    @Path("/claims/{claim_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ClaimByIdResponse> getClaimDetails(
        @HeaderParam("Authorization") String accessToken,
        @PathParam("claim_id") String claimId
    ) {
        return service.fetchClaimById(accessToken, claimId);
    }


    @GET
    @Path("/claims/{claim_id}/detail")
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
    @Path("/claims/search")
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
    @Path("/claims/{claim_id}/reasons/{reason_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ClaimReasonResponse> getClaimReason(
        @HeaderParam("Authorization") String accessToken,
        @PathParam("reason_id") String reasonId
    ) {
        return service.fetchClaimReason(accessToken, reasonId);
    }

    @GET
    @Path("/claims/{claim_id}/actions-history")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<ClaimHistoryResponse.ActionItem>> getClaimActionHistory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    ){
        return service.fetchClaimActionHistory(authorization, claimId);
    }

    @GET
    @Path("/claims/{claim_id}/status-history")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<ClaimHistoryResponse.HistoryItem>> getClaimStatusHistory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    ) {
        return service.fetchClaimStatusHistory(authorization, claimId); 
    }

    @GET
    @Path("/claims/{claim_id}/affects-reputation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ClaimHistoryResponse> getClaimReputation(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    ){
        return service.fetchReputation(authorization, claimId);
    }

    @GET
    @Path("/claims/{claim_id}/messages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<ClaimMessagesResponse>> getClaimMessages(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    ){
        return service.fetchClaimMessages(authorization, claimId);
    }

    @POST
    @Path("/claims/{claim_id}/attachments")
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
    @Path("/claims/{claim_id}/actions/send-message")
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
    @Path("/claims/{claim_id}/attachments/{attachment_id}")
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
    @Path("/claims/{claim_id}/actions/open-dispute")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<DisputeResponse> postDisput(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id
    ) {
        return service.sendDispute(authorization, claim_id);
    }

    @GET
    @Path("/claims/{claim_id}/expected-resolutions")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<ClaimHistoryResponse.ActionItem>> getResolutions(
                @HeaderParam("Authorization") String authorization,
            @PathParam("claim_id")String claim_id){
            return service.fetchResolution(authorization, claim_id);
            }

    @GET
    @Path("/claims/{claim_id}/partial-refund/available-offers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<PartialRefoundResponse> getPartialRefund(
            @HeaderParam("Authorization") String authorization,
            @PathParam("claim_id")String claim_id
    ){
        return service.fetchPartialRefund(authorization, claim_id);
    }

    @POST
    @Path("/claims/{claim_id}/expected-resolutions/partial-refund")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<RefundResponse> postPartialRefund(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id,
        RefundRequest request
    ){
        return service.sendPartialRefund(authorization, claim_id, request);
    }

    @POST
    @Path("/claims/{claim_id}/expected-resolutions/refund")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<RefundResponse>> postRefund(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id
    ){
        return service.sendRefund(authorization, claim_id);
    }

    
    @POST
    @Path("/claims/{claim_id}/expected-resolutions/allow-return")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List<RefundResponse>> postAllowRefund(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id
    ){
        return service.sendAllowRefund(authorization, claim_id);
    }

     @GET
    @Path("/claims/{claim_id}/attachments-evidences/{attachment_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<GetFileResponse> postEvidences(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id")String claim_id,
        @PathParam("attachment_id")String attachment_id
    ){
        return service.sendEvidences(authorization, claim_id, attachment_id);
    }

        @POST
    @Path("/claims/{claim_id}/attachments-evidences")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Uni<FileAttachmentResponse> postEvidenceFile(
            @HeaderParam("Authorization")String authorization,
            @PathParam("claim_id") String claim_id,
            ImagemUploadForm form
    ){
        return service.sendEvidencesFile(authorization ,claim_id ,form );
    }

    @POST
    @Path("/claims/{claim_id}/actions/evidences")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<EvidenceResponse> postActionEvidence(
            @HeaderParam("Authorization")String authorization,
            @PathParam("claim_id") String claim_id,
            EvidenceRequest request
    ){
        return service.sendActionEvidence(authorization, claim_id, request);
    }


        @GET
    @Path("/claims/{claim_id}/returns")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<DevolucoesResponse> getDevolucoes(
            @HeaderParam("Authorization")String authorization,
            @PathParam("claim_id")String claim_id
    ){
        return service.fetchDevolucoes(authorization, claim_id);
    }

        @POST
    @Path("/claims/{claim_id}/actions/return-review-ok")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ReturnReviewOkResponse> postReturnOK(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id
    ){
        return service.sendReturnOk(authorization, claim_id);
    }

    @GET
    @Path("/returns/reasons/return-fail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<ReturnReviewFailResponse> postReturnFail(
        @HeaderParam("Authorization") String authorization
    )
    {
        return service.sendReturnFail(authorization);
    }
}
