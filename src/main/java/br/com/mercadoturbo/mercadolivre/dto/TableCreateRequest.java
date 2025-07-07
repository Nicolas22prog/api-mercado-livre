package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class TableCreateRequest {
    
    public Names names;
    public String domain_id;
    public String site_id;
    public MainAttribute main_attribute;
    public List<Attribute> attributes;
    public List<Row> rows;

    public static class Names {
        public String MLB;
    }

    public static class MainAttribute {
        public List<AttributeRef> attributes;

        public static class AttributeRef {
            public String site_id;
            public String id;
        }
    }

    public static class Attribute {
        public String id;
        public List<Value> values;

        public static class Value {
            public String id;
            public String name;
        }
    }

    public static class Row {
        public List<AttributeValue> attributes;

        public static class AttributeValue {
            public String id;
            public List<Value> values;

            public static class Value {
                public String name;
            }
        }
    }
}