package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class EvidenceResponse {
    public List<Evidence> evidences;

    public static class Evidence {
        public List<String> attachments;
        public String type;
        public OffsetDateTime date_shipped;
        public OffsetDateTime date_delivered;
        public String destination_agency;
        public String receiver_email;
        public String receiver_id;
        public String receiver_name;
        public String shipping_company_name;
        public String shipping_method;
        public String tracking_number;
        public OffsetDateTime handling_date;
    }
}
