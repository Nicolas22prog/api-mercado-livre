package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class EvidenceRequest {
    public String type;
    public String shipping_method;
    public String shipping_company_name;
    public String destination_agency;
    public OffsetDateTime date_shipped;
    public String receiver_name;
    public String receiver_id;
    public String tracking_number;
    public List<String> attachments;
}
