package br.com.mercadoturbo.mercadolivre.dto;

    public class VariationsRequest {
    public Variation[] variations;

    public static class Variation {
        public Long id;
        public AttributeCombination[] attribute_combinations;

        public static class AttributeCombination {
            public String id;
            public String value_id;
        }
    }
}
