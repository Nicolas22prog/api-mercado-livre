package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class MedidasRequest {
    public List<Attribute> attributes;

    public static class Attribute {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public Object value_struct;
        public List<Value> values;
        public String attribute_group_id;
        public String attribute_group_name;
    }

    public static class Value {
        public String id;
        public String name;
        public Object struct;
    }
}