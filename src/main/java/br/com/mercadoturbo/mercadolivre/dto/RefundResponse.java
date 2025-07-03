package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class RefundResponse extends ProxyEnabledDTO{
        public String player_role;
        public Long user_id;
        public List<Detail> details;
        public String expected_resolution;
        public String date_created;
        public String last_updated;
        public String status;

    public static class Detail {
        public String key;
        public String value;
    }
}
