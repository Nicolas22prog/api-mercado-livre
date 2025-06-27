package br.com.mercadoturbo.mercadolivre.dto;

public class VariationsUpdateRequest {
    public Picture[] pictures;
    public Variation[] variations;

    public static class Picture {
        public String id;
        public String source;
    }

    public static class Variation {
        public Long id;
        public String[] picture_ids;
        public AttributeCombination[] attribute_combinations;

        public static class AttributeCombination {
            public String id;
            public String value_id;
        }
    }
}
