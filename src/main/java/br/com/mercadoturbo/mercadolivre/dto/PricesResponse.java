package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class PricesResponse {

    public String id;
    public List<Price> prices;

    public static class Price {
        public String id;
        public String type;
        public double amount;
        public Double regular_amount; // pode ser null
        public String currency_id;
        public OffsetDateTime last_updated;
        public Conditions conditions;
    }

    public static class Conditions {
        public List<String> context_restrictions;
        public OffsetDateTime start_time; // pode ser null
        public OffsetDateTime end_time;   // pode ser null
    }
}
