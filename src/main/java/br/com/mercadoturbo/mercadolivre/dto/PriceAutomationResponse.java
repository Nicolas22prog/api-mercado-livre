package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;


public class PriceAutomationResponse {
    public String item_id;
    public String status;
    public ItemRule item_rule;
    public BigDecimal min_price;
    public BigDecimal max_price;

    public static class ItemRule {
        public String rule_id;
    }
}
