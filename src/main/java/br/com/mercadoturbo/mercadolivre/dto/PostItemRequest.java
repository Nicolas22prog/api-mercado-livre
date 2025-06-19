package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;

public class PostItemRequest {

    public String family_name;
    public String category_id;
    public BigDecimal price;
    public String currency_id;
    public Integer available_quantity;
    public SaleTerm[] sale_terms;
    public String buying_mode;
    public String listing_type_id;
    public String condition;
    public Picture[] pictures;
    public Attribute[] attributes;

    public static class SaleTerm {
        public String id;
        public String value_name;
    }

    public static class Picture {
        public String source;
    }

    public static class Attribute {
        public String id;
        public String value_name;
    }
}