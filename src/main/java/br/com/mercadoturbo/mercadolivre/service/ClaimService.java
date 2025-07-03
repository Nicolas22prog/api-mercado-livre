package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreClaimApi;
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
import br.com.mercadoturbo.mercadolivre.resource.ClaimHistoryResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClaimService implements Serializable{

    @Inject
    @RestClient
    MercadoLivreClaimApi claimApi;

    public Uni<ClaimByIdResponse> fetchClaimById(String accessToken, String claimId) {
        return claimApi.getClaimById(accessToken, claimId);
    }
    
    public Uni<ClaimDetailResponse> fetchClaimDetail(String accessToken, String claimId) {
        return claimApi.getClaimDetail(accessToken, claimId);
    }

    public Uni<ClaimsResponse> fetchClaims(String accessToken, String status, String stage, String sort, Integer offset, Integer limit) {
        return claimApi.getClaims(accessToken, status, stage, sort, offset, limit);
    }

    public Uni<ClaimReasonResponse> fetchClaimReason(String accessToken, String reasonId) {
        return claimApi.getClaimReason(accessToken, reasonId);
    }

    public Uni<List<ClaimHistoryResponse.ActionItem>> fetchClaimActionHistory(String accessToken, String claimId) {
        return claimApi.getClaimActionHistory(accessToken, claimId);
    }

    public Uni<List<ClaimHistoryResponse.HistoryItem>> fetchClaimStatusHistory(String accessToken, String claimId) {
        return claimApi.getClaimStatusHistory(accessToken, claimId);
    }

    public Uni<ClaimHistoryResponse> fetchReputation(String accessToken, String claimId) {
        return claimApi.getClaimReputation(accessToken, claimId);
    }

    public Uni<List<ClaimMessagesResponse>> fetchClaimMessages(String accessToken, String claimId) {
        return claimApi.getClaimMessages(accessToken, claimId);
    }

    public Uni<FileAttachmentResponse> sendAttachment(String accessToken, String claimId, ImagemUploadForm request) {
        return claimApi.postAttachment(accessToken, claimId, request);
    }

    public Uni<String> sendMessage(String accessToken, String claim_id, SendMessageRequest   request){
        return claimApi.postMessage(accessToken, claim_id, request);
    }

    public Uni<GetFileResponse> fetchFileResponse(String accessToken, String claim_id, String attachment_id){
        return claimApi.getFileResponse(accessToken, claim_id, attachment_id);
    }

    public Uni<DisputeResponse> sendDispute(String accessToken, String claim_id){
        return claimApi.postDisput(accessToken, claim_id);
    }

    public Uni<List<ClaimHistoryResponse.ActionItem>> fetchResolution(String accessToken, String claim_id){
        return claimApi.getResolutions(accessToken, claim_id);
    }

    public Uni<PartialRefoundResponse> fetchPartialRefund(String accessToken, String claim_id){
        return claimApi.getPartialRefund(accessToken, claim_id);
    }

    public Uni<RefundResponse> sendPartialRefund(String accessToken, String claim_id, RefundRequest request){
        return claimApi.postPartialRefund(accessToken, claim_id, request);
    }

    public Uni<List<RefundResponse>> sendRefund(String accessToken, String claim_id){
        return claimApi.postRefund(accessToken, claim_id);
    }

     public Uni<List<RefundResponse>> sendAllowRefund(String accessToken, String claim_id){
        return claimApi.postAllowRefund(accessToken, claim_id);
    }

    public Uni<GetFileResponse> sendEvidences(String accessToken, String claim_id, String attachment){
        return claimApi.postEvidences(accessToken, claim_id, attachment);
    }

    public Uni<FileAttachmentResponse> sendEvidencesFile(String accessToken, String claim_id,ImagemUploadForm form)
    {
        return claimApi.postEvidenceFile(accessToken, claim_id, form);
    }

    public Uni<EvidenceResponse> sendActionEvidence(String accessToken,String claim_id, EvidenceRequest request){
        return claimApi.postActionEvidence(accessToken, claim_id, request);
    }

    public Uni<DevolucoesResponse> fetchDevolucoes(String accesTokens, String claim_id){
        return claimApi.getDevolucoes(accesTokens, claim_id);
    }

    public Uni<ReturnReviewOkResponse> sendReturnOk(String accessToken, String claim_id){
        return claimApi.postReturnOK(accessToken, claim_id);
    }

        public Uni<ReturnReviewFailResponse> sendReturnFail(String accessToken){
        return claimApi.postReturnFail(accessToken);
    }

    public Uni<FileAttachmentResponse> sendReturnEvidence(String accessToken,String claim_id, ImagemUploadForm form){
        return claimApi.postAttachment(accessToken, claim_id, form);
    }

    public Uni<ReturnReviewOkResponse> sendFailReason(String accessToken, String claim_id, List<ReviewMessageRequest> request){
        return claimApi.postFailReason(accessToken, claim_id, request);
    }

    public Uni<ChangesCost> fetchChangesCost(String accessToken, String claim_id, Boolean calculate_amount_usd){
        return claimApi.getChangeCost(accessToken, claim_id, calculate_amount_usd);
    }
}
