package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;
import java.util.Map;

public class TableCreateRequest {
    public Map<String, String> names;
    public String domain_id;
    public String site_id;
    public MainAttribute main_attribute;
    public List<Attribute> attributes;
    public List<Row> rows;
    public List<String> sites;

    public static class MainAttribute {
        public List<AttributeId> attributes;
    }

    public static class AttributeId {
        public String site_id;
        public String id;
    }

   public static class Attribute {
    public String id;
    public String name;
    public List<Attribute> values; // recursivo
    public List<Value> valuesSimple; // para casos simples
}
public static class Value {
    public String id;
    public String name;
}

    public static class Row {
        public List<Attribute> attributes;
    }
}