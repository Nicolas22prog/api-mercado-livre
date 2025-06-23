package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class QuantityPriceRequest {
    public List<Price> prices;

    public static class Price {
        public String id; // opcional
        public Double amount; // opcional — depende se o campo id estiver presente
        public String currency_id; // opcional
        public Conditions conditions;
    }

    public static class Conditions {
        public List<String> context_restrictions;
        public Integer min_purchase_unit; // opcional
    }
}
