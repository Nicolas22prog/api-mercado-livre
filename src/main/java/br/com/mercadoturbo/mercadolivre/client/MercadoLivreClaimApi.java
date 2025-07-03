package br.com.mercadoturbo.mercadolivre.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.apiexception.MercadoLivreExceptionMapper;
import br.com.mercadoturbo.mercadolivre.dto.ChangesCost;
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
import br.com.mercadoturbo.mercadolivre.dto.ReviewMessageRequest;
import br.com.mercadoturbo.mercadolivre.dto.SendMessageRequest;
import br.com.mercadoturbo.mercadolivre.dto.ClaimHistoryResponse;
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

@Path("/post-purchase/v1")
@RegisterRestClient(configKey = "mercado-livre-api")
@RegisterProvider(MercadoLivreExceptionMapper.class)
public interface MercadoLivreClaimApi {
    
    @GET
    @Path("/claims/{claim_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimByIdResponse> getClaimById(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @GET
    @Path("/claims/{claim_id}/detail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimDetailResponse> getClaimDetail(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );


    @GET
    @Path("/claims/search")
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
    @Path("/claims/{claim_id}/reasons/{reason_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimReasonResponse> getClaimReason(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id,
        @PathParam("reason_id") String reasonId
    );


    @GET
    @Path("/claims/{claim_id}/actions-history")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<ClaimHistoryResponse.ActionItem>> getClaimActionHistory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @GET
    @Path("/claims/{claim_id}/status-history")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<ClaimHistoryResponse.HistoryItem>> getClaimStatusHistory(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @GET
    @Path("/claims/{claim_id}/affects-reputation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ClaimHistoryResponse> getClaimReputation(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @GET
    @Path("/claims/{claim_id}/messages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<ClaimMessagesResponse>> getClaimMessages(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId
    );

    @POST
    @Path("/claims/{claim_id}/attachments")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    Uni<FileAttachmentResponse> postAttachment(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id") String claimId,
        ImagemUploadForm request
    );

    @POST
    @Path("/claims/{claim_id}/actions/send-message")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<String> postMessage(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id,
        SendMessageRequest request
    );

    @GET
    @Path("/claims/{claim_id}/attachments/{attachment_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<GetFileResponse> getFileResponse(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id,
        @PathParam("attachemnte_id") String attachment_id
    );

    @POST
    @Path("/claims/{claim_id}/actions/open-dispute")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<DisputeResponse> postDisput(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id
    );

    @GET
    @Path("/claims/{claim_id}/expected-resolutions")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<ClaimHistoryResponse.ActionItem>> getResolutions(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id);


    @GET
    @Path("/claims/{claim_id}/partial-refund/available-offers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<PartialRefoundResponse> getPartialRefund(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id
    );


    @POST
    @Path("/claims/{claim_id}/expected-resolutions/partial-refund")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<RefundResponse> postPartialRefund(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id,
        RefundRequest request
    );

    @POST
    @Path("/claims/{claim_id}/expected-resolutions/refund")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<RefundResponse>> postRefund(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id
    );

    @POST
    @Path("/claims/{claim_id}/expected-resolutions/allow-replace")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<List<RefundResponse>> postAllowRefund(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id
    );

    @GET
    @Path("/claims/{claim_id}/attachments-evidences/{attachment_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<GetFileResponse> postEvidences(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id")String claim_id,
        @PathParam("attachment_id")String attachment_id
    );

    @POST
    @Path("/claims/{claim_id}/attachments-evidences")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    Uni<FileAttachmentResponse> postEvidenceFile(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id,
        ImagemUploadForm form
    );

    @POST
    @Path("/claims/{claim_id}/actions/evidences")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<EvidenceResponse> postActionEvidence(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id") String claim_id,
        EvidenceRequest request
    );

    @GET
    @Path("/claims/{claim_id}/changes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<DevolucoesResponse> getDevolucoes(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id")String claim_id
    );


    @POST
    @Path("/claims/{claim_id}/actions/return-review-ok")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ReturnReviewOkResponse> postReturnOK(
        @HeaderParam("Authorization") String authorization,
        @PathParam("claim_id")String claim_id
    );

    @GET
    @Path("/returns/reasons/return-fail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ReturnReviewFailResponse> postReturnFail(
        @HeaderParam("Authorization") String authorization
    );

    @POST
    @Path("/claims/{claim_id}/actions/return-review-fail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ReturnReviewOkResponse> postFailReason(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id")String claimId,
        List<ReviewMessageRequest> request
    ); 

    
    @POST
    @Path("/claims/{claim_id}/returns/attachments")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    Uni<FileAttachmentResponse> postReturnEvidence(
            @HeaderParam("Authorization") String authorization,
            @PathParam("claim_id")String claim_id,
            ImagemUploadForm form
    );

    @GET
    @Path("/claims/{claim_id}/charges/return-cost")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<ChangesCost> getChangeCost(
        @HeaderParam("Authorization")String authorization,
        @PathParam("claim_id")String claim_id,
        @QueryParam("calculate_amount_usd") Boolean calculate_amount_usd
    );
}
