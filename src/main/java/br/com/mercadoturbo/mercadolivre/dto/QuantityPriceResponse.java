package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class QuantityPriceResponse extends ProxyEnabledDTO{
 public String id;
    public List<Price> prices;

    public static class Price {
        public String id;             // opcional
        public Double amount;         // opcional
        public String currency_id;    // opcional
        public Conditions conditions;
    }

    public static class Conditions {
        public List<String> context_restrictions;
        public Integer min_purchase_unit; // opcional
    }
}
