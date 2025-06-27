package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;

public class VariationRequest {
    public AttributeCombination[] attribute_combinations;
    public BigDecimal price;
    public Integer available_quantity;
    public Integer sold_quantity;
    public String[] picture_ids;

    public static class AttributeCombination {
        public String id;
        public String value_id;
    }
}