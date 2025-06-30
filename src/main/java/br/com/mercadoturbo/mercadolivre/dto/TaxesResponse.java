package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class TaxesResponse extends ProxyEnabledDTO{
    public Paging paging;
    public List<Object> results;
    public List<Sort> sort;
    public List<Object> filters;
    public List<Object> available_filters;
    public List<Object> available_sorts;

    public static class Paging {
        public int total;
        public int offset;
        public int limit;
    }

    public static class Sort {
        public String id;
        public String name;
    }
}
