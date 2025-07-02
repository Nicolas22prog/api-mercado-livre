package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class ClaimsResponse extends ProxyEnabledDTO{
    public Paging paging;
    public List<ClaimData> data;

    public static class Paging {
        public int total;
        public int offset;
        public int limit;
    }

    public static class ClaimData {
        public long id;
        public long resource_id;
        public String status;
        public String type;
        public String stage;
        public Long parent_id;
        public String resource;
        public String reason_id;
        public boolean fulfilled;
        public String quantity_type;
        public List<Player> players;
        public Resolution resolution;
        public String site_id;
        public OffsetDateTime date_created;
        public OffsetDateTime last_updated;
    }

    public static class Player {
        public String role;
        public String type;
        public long user_id;
        public List<AvailableAction> available_actions;
    }

    public static class AvailableAction {
        public String action;
        public boolean mandatory;
        public OffsetDateTime due_date;
    }

    public static class Resolution {
        public String reason;
        public OffsetDateTime date_created;
        public List<String> benefited;
        public String closed_by;
        public boolean applied_coverage;
    }
}
