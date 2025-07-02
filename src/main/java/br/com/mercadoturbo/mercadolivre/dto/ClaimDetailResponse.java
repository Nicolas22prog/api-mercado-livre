package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;

public class ClaimDetailResponse extends ProxyEnabledDTO{
    public OffsetDateTime due_date;
    public String action_responsible;
    public String title;
    public String description;
    public String problem;
}
