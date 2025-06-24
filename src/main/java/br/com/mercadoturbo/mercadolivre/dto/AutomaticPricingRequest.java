package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;


public class AutomaticPricingRequest {
    public String rule_id;
    public BigDecimal min_price;
    public BigDecimal max_price;
}
