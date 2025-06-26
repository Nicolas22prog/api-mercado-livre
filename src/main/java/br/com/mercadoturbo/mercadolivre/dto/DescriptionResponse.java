package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;


public class DescriptionResponse extends ProxyEnabledDTO{
   

    public String text;
    public String plain_text;
    public OffsetDateTime last_updated;
    public OffsetDateTime date_created;
    public Snapshot snapshot;


    public static class Snapshot {
        public String url;
        public int width;
        public int height;
        public String status;
    }
}

