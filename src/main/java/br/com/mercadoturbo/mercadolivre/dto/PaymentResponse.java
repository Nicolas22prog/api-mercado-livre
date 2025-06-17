package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PaymentResponse extends ProxyEnabledDTO{
    public Long id;
    public OffsetDateTime date_created;
    public OffsetDateTime date_approved;
    public OffsetDateTime date_last_updated;
    public OffsetDateTime money_release_date;
    public String payment_method_id;
    public String payment_type_id;
    public String status;
    public String status_detail;
    public String currency_id;
    public String description;
    public Long collector_id;
    public Payer payer;
    public Object metadata;
    public Object additional_info;
    public String external_reference;
    public BigDecimal transaction_amount;
    public BigDecimal transaction_amount_refunded;
    public BigDecimal coupon_amount;
    public TransactionDetails transaction_details;
    public Integer installments;
    public Object card;

    public static class Payer {
        public Long id;
        public String email;
        public Identification identification;
        public String type;

        public static class Identification {
            public String type;
            public Long number;
        }
    }

    public static class TransactionDetails {
        public BigDecimal net_received_amount;
        public BigDecimal total_paid_amount;
        public BigDecimal overpaid_amount;
        public BigDecimal installment_amount;
    }
}