package br.com.mercadoturbo.mercadolivre.dto;


import java.util.List;

public class AttributesResponse extends ProxyEnabledDTO{

    public String id;
    public String name;
    public Tags tags;
    public String hierarchy;
    public int relevance;
    public String value_type;
    public Integer value_max_length;
    public String type;
    public String default_unit;
    public String tooltip;
    public String hint;
    public String example;
    public String attribute_group_id;
    public String attribute_group_name;
    public List<Unit> allowed_units;
    public List<Value> values;

    public static class Tags {
        public Boolean hidden;
        public Boolean read_only;
        public Boolean variation_attribute;
        public Boolean catalog_required;
        public Boolean required;
        public Boolean catalog_listing_required;
        public Boolean multivalued;
        public Boolean used_hidden;
        public Boolean validate;
        public Boolean conditional_required;
    }

    public static class Unit {
        public String id;
        public String name;
    }

    public static class Value {
        public String id;
        public String name;
        public Metadata metadata;
    }

    public static class Metadata {
        public Boolean value;
    }
}


