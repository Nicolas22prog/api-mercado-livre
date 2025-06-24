package br.com.mercadoturbo.mercadolivre.dto;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class PriceSuggestionDTO extends ProxyEnabledDTO{
  public String item_id;
    public String status;
    public String currency_id;
    public BigDecimal ratio;
    public Price current_price;
    public Price suggested_price;
    public Price lowest_price;
    public Price internal_price;
    public Costs costs;
    public Boolean applicable_suggestion;
    public BigDecimal percent_difference;
    public Metadata metadata;
    public OffsetDateTime last_updated;

    public static class Price {
        public BigDecimal amount;
        public BigDecimal usd_amount;
    }

    public static class Costs {
        public BigDecimal selling_fees;
        public BigDecimal shipping_fees;
    }

    public static class Metadata {
        public List<Graph> graph;
        public Integer compared_values;

        public static class Graph {
            public Price price;
            public Info info;

            public static class Info {
                public String title;
                public Integer sold_quantity;
            }
        }
    }
}
