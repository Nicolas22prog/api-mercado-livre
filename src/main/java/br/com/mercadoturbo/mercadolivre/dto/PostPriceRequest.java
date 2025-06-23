package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class PostPriceRequest {

    public List<Price> prices;

    public static class Price {
        public Conditions conditions;
        public double amount;
        public String currency_id;
    }

    public static class Conditions {
        public List<String> context_restrictions;
    }
}
