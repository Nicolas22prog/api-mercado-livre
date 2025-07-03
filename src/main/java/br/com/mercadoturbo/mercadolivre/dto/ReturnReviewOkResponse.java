package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class ReturnReviewOkResponse extends ProxyEnabledDTO{
    public Long id;
    public Long resource_id;
    public String status;
    public String type;
    public String stage;
    public Long parent_id;
    public String resource;
    public String reason_id;
    public Boolean fulfilled;
    public String quantity_type;
    public List<Player> players;
    public Resolution resolution;
    public String site_id;
    public String date_created;
    public String last_updated;

    public static class Player {
        public String role;
        public String type;
        public Long user_id;
        public List<AvailableAction> available_actions;
    }

    public static class AvailableAction {
        public String action;
        public Boolean mandatory;
        public String due_date;
    }

    public static class Resolution {
        public String reason;
        public String date_created;
        public List<String> benefited;
        public String closed_by;
        public Boolean applied_coverage;
    }
}
