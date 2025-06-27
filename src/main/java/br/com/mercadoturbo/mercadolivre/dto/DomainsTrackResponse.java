package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class DomainsTrackResponse extends ProxyEnabledDTO{
    public List<Domain> domains;

    public static class Domain {
        public String domain_id;
    }
}