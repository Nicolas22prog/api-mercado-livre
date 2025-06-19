package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class ItemsResponse extends ProxyEnabledDTO {

    public String seller_id;
    public List<String> results;
    public Paging paging;
    public String query;
    public List<Order> orders;
    public List<AvailableOrder> available_orders;

    public static class Paging {
        public int limit;
        public int offset;
        public int total;
    }

    public static class Order {
        public String id;
        public String name;
    }

    public static class AvailableOrder {
        public Object id;
        public String name;
    }

    public static class AvailableOrderId {
        public String id;
        public String field;
        public String missing;
        public String order;
    }
}
