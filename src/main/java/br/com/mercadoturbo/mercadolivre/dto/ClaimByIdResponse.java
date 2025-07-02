package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class ClaimByIdResponse {
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
    public Integer claimed_quantity;
    public Double claim_version;
    public List<Player> players;
    public Resolution resolution;
    public String site_id;
    public String date_created;
    public String last_updated;
    public List<Object> related_entities;

    public static class Player {
        public String role;
        public String type;
        public Long user_id;
        public List<Object> available_actions;
    }

    public static class Resolution {
        public String reason;
        public String date_created;
        public List<String> benefited;
        public String closed_by;
        public Boolean applied_coverage;
    }
}
