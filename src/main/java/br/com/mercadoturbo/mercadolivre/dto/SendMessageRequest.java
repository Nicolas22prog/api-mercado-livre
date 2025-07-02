package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class SendMessageRequest {
    public String receiver_role;
    public String message;
    public List<String> attachments;
}
