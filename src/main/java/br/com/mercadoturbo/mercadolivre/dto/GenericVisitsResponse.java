package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;


public class GenericVisitsResponse extends ProxyEnabledDTO{
    public Integer total;
    public OffsetDateTime date_from;
    public OffsetDateTime date_to;
    
    public String item_id;
    public String user_id;
}
