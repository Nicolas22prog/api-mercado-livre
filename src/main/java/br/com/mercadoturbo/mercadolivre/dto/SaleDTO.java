package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;


public class SaleDTO extends ProxyEnabledDTO{
    public String price_id;
    public double amount;
    public double regular_amount;
    public String currency_id;
    public OffsetDateTime reference_date;
    public Metadata metadata;

    public static class Metadata {
        public String promotion_id;     // opcional — aparece apenas com token do proprietário
        public String promotion_type;   // opcional — aparece apenas com token do proprietário
    }
}
