package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class CatalogRequest {
    public String domain_id;
    public String site_id;
    public Long seller_id;
    public List<Attribute> attributes;
    public String type;

    public static class Attribute {
        public String id;
        public List<Value> values;
    }

    public static class Value {
        public String name;
    }
}