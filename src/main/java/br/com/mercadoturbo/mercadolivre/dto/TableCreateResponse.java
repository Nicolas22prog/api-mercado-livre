package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;
import java.util.Map;

public class TableCreateResponse extends ProxyEnabledDTO{
     public String id;
    public Map<String, String> names;
    public String domain_id;
    public String site_id;
    public String type;
    public Long seller_id;
    public String main_attribute_id;
    public String secondary_attribute_id;
    public List<Attribute> attributes;
    public List<Row> rows;
    public String message;

    public static class Attribute {
        public String id;
        public String name;
        public List<Value> values;
    }

    public static class Value {
        public String id;
        public String name;
        public Struct struct;
    }

    public static class Struct {
        public Double number;
        public String unit;
    }

    public static class Row {
        public String id;
        public List<Attribute> attributes;
    }
}
