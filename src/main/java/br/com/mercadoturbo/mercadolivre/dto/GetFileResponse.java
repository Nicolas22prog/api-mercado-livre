package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;

public class GetFileResponse extends ProxyEnabledDTO{
    public String filename;
    public String original_filename;
    public long size;
    public OffsetDateTime date_created;
    public String type;
}
