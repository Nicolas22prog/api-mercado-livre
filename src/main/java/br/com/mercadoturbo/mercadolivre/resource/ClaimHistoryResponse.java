package br.com.mercadoturbo.mercadolivre.resource;

import java.time.OffsetDateTime;
import java.util.List;

public class ClaimHistoryResponse {
    // Para o primeiro JSON: lista de ações
    public List<ActionItem> actions;

    // Para o segundo JSON: lista de histórico
    public List<HistoryItem> history;

    // Para o terceiro JSON: detalhes simples
    public String affects_reputation;
    public Boolean has_incentive;
    public OffsetDateTime due_date;

    public static class ActionItem {
        public String action_name;
        public String player_role;
        public Long user_id;
        public String action_reason_id;
        public String claim_stage;
        public String claim_status;
        public String expected_resolution;
        public List<Object> details;
        public OffsetDateTime date_created;
        public OffsetDateTime last_updated;
        public String status;
    }

    public static class HistoryItem {
        public String stage;
        public String status;
        public OffsetDateTime date;
        public String change_by;
    }
}
