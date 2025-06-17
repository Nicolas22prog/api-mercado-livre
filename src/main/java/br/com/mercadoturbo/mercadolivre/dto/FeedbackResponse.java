package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;


public class FeedbackResponse extends ProxyEnabledDTO{
  public Sale sale;
    public Object purchase;

    public static class Sale {
        public To to;
        public List<Object> extended_feedback;
        public boolean has_seller_refunded_money;
        public String status;
        public String reason;
        public String site_id;
        public OffsetDateTime date_created;
        public From from;
        public long order_id;
        public boolean modified;
        public long id;
        public String message;
        public boolean fulfilled;
        public Item item;
        public OffsetDateTime visibility_date;
        public String reply;
        public String role;
        public String app_id;
        public String rating;
        public boolean restock_item;
    }

    public static class To {
        public long id;
        public String status;
        public String nickname;
        public int points;
    }

    public static class From {
        public long id;
        public String status;
        public String nickname;
        public int points;
    }

    public static class Item {
        public String id;
        public String title;
        public BigDecimal price;
        public String currency_id;
    }
}
