package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;
import java.util.Map;

public class CatalogResponse {
    public Paging paging;
    public List<Chart> charts;

    public static class Paging {
        public int total;
        public int offset;
        public int limit;
    }

    public static class Chart {
        public String id;
        public Map<String, String> names;
        public String domain_id;
        public String type;
        public String main_attribute_id;
        public String secondary_attribute_id;
        public List<Attribute> attributes;
        public List<Row> rows;
    }

    public static class Attribute {
        // Defina campos conforme necessário
    }

    public static class Row {
        // Defina campos conforme necessário
    }
}