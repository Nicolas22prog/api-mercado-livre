package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;
import java.util.Map;

public class DomainResponse extends ProxyEnabledDTO{
    public Input input;
    public Map<String, Object> output;

    public static class Input {
        public List<Group> groups;
    }

    public static class Group {
        public String id;
        public String label;
        public Integer relevance;
        public String section;
        public Map<String, Object> ui_config;
        public List<Component> components;
    }

    public static class Component {
        public String component;
        public String label;
        public UiConfig ui_config;
        public List<Attribute> attributes;
        public List<Component> components; // recursivo
        public String default_unified_unit_id;
        public String default_unit_id;
        public List<Unit> units;
        public List<Unit> unified_units;
    }

    public static class UiConfig {
        public Boolean allow_custom_value;
        public Boolean allow_filtering;
        public Integer max_allowed;
    }

    public static class Attribute {
        public String id;
        public String name;
        public String value_type;
        public Integer value_max_length;
        public List<String> tags;
        public List<Value> values;
        public String hierarchy;
        public Integer relevance;
        public String attribute_group_id;
        public String attribute_group_name;
        public String default_unit_id;
        public List<Unit> units;
    }

    public static class Value {
        public String id;
        public String name;
        public Object struct;
    }

    public static class Unit {
        public String id;
        public String name;
    }
}