package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.util.List;

public class AttributesRequest {
    public BigDecimal price;
    public String title;
    public List<Attribute> attributes;
    public String status;
    public Boolean deleted;
    public Integer available_quantity;
    public List<Sale_term> sale_terms;
    public static class Attribute {
        public String id;
        public String value_name;
    }
    public static class Sale_term {
        public String id;
        public String value_id;
        public String value_name;
    }
}