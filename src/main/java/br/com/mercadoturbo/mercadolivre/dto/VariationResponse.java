package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.util.List;


public class VariationResponse {
    public Long id;
    public BigDecimal price;
    public List<AttributeCombination> attribute_combinations;
    public Integer available_quantity;
    public Integer sold_quantity;
    public List<Object> sale_terms;
    public List<String> picture_ids;
    public Object seller_custom_field;
    public Object catalog_product_id;
    public Object inventory_id;
    public List<Object> item_relations;
    public String user_product_id;

    public static class AttributeCombination {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public List<Value> values;
        public String value_type;

        public static class Value {
            public String id;
            public String name;
            public Object struct;
        }
    }
}

