package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;

public class VisitsResponse extends ProxyEnabledDTO{

    public String item_id;
    public Long user_id;
    public OffsetDateTime date_from;
    public OffsetDateTime date_to;
    public Integer total_visits;
    public VisitDetail[] visits_detail;

    public static class VisitDetail {
        public String company;
        public Integer quantity;
    }
}