package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class ReviewMessageRequest {
    public String reason;
    public String message;
    public Long order_id;
    public List<String> attachments;
}
