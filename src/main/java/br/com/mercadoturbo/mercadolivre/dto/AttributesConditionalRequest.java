package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.util.List;


public class AttributesConditionalRequest{
         public String title;
    public String category_id;
    public BigDecimal price; // <- ajustado para BigDecimal
    public String currency_id;
    public Integer available_quantity;
    public String buying_mode;
    public String condition;
    public String listing_type_id;
    public Description description;
    public String video_id;
    public List<SaleTerm> sale_terms;
    public List<Picture> pictures;
    public List<Attribute> attributes;

    public static class Description {
        public String plain_text;
    }

    public static class SaleTerm {
        public String id;
        public String value_name;
    }

    public static class Picture {
        public String source;
    }

    public static class Attribute {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public Object value_struct;
        public List<Object> values;
        public String attribute_group_id;
        public String attribute_group_name;
    }
}
