package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.util.List;

public class FaturamentoResponse extends ProxyEnabledDTO {
    public Integer offset;
    public Integer limit;
    public Integer total;
    public List<Result> results;

    public static class Result {
        public Long id;
        public Long user_id;
        public String document_type;
        public String associated_document_id;
        public String document_status;
        public String site_id;
        public String currency_id;
        public Integer count_details;
        public List<File> files;
        public BigDecimal amount;
        public BigDecimal unpaid_amount;
        public Period period;
        public String key;
        public String expiration_date;
        public String debt_expiration_date;
        public String debt_expiration_date_move_reason;
        public String debt_expiration_date_move_reason_description;
        public String period_status;
    }

    public static class File {
        public String file_id;
        public String reference_number;
    }

    public static class Period {
        public String date_from;
        public String date_to;
    }
}
