package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class MensagemAdicionalResponse extends ProxyEnabledDTO {
    public Integer id;
    public Integer issuer;
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
