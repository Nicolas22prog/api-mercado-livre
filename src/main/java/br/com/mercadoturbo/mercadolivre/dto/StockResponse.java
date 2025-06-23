package br.com.mercadoturbo.mercadolivre.dto;

public class StockResponse {

    public Location[] locations;
    public Long user_id;
    public String id;

    public static class Location {
        public String type;
        public String network_node_id;
        public String store_id;
        public Integer quantity;
    }
}
