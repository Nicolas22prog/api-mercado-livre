package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class ClaimReasonResponse extends ProxyEnabledDTO{
    public String id;
    public String flow;
    public String name;
    public String detail;
    public int position;
    public Filter filter;
    public Settings settings;
    public String parent_id;
    public String children_title;
    public String status;
    public OffsetDateTime date_created;
    public OffsetDateTime last_updated;

    public static class Filter {
        public List<String> group;
        public List<String> site_id;
    }

    public static class Settings {
        public List<String> allowed_flows;
        public List<String> expected_resolutions;
        public List<String> rules_engine_triage;
    }
}
