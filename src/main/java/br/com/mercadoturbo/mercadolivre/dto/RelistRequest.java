package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;

public class RelistRequest {
    public String listing_type_id;
    public Variation[] variations;

    public static class Variation {
        public Long id;
        public BigDecimal price;
        public Integer quantity;
    }
}
