package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;

public class VisitsTimeWindowResponse extends ProxyEnabledDTO{
    
    public String item_id;
    public Long user_id;
    public OffsetDateTime date_from;
    public OffsetDateTime date_to;
    public Integer total_visits;
    public Integer total;
    public Integer last;
    public String unit;
    public Result[] results;

    public static class Result {
        public OffsetDateTime date;
        public Integer total;
        public VisitDetail[] visits_detail;
    }

    public static class VisitDetail {
        public String company;
        public Integer quantity;
    }
}
