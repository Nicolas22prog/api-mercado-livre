package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class KnownAttributesRequest extends ProxyEnabledDTO{
    public List<KnownAttribute> known_attributes;

    public static class KnownAttribute {
        public String id;
        public String value_id;
    }
}