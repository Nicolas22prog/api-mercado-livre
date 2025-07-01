package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class MensagemAdicionalRequest {
    public Integer id;
    public String title;
    public String message;
    public String type;
    public List<Filter> filters;

    public static class Filter {
        public String name;
        public String operation;
        public String value;
    }
}
