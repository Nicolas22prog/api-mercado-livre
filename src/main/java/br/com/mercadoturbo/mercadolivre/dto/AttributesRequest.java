package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class AttributesRequest {
    public List<Attribute> attributes;

    public static class Attribute {
        public String id;
        public String value_name;
    }
}