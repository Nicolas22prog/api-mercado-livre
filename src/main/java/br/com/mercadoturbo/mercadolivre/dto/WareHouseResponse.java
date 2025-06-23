package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;
import java.util.List;


public class WareHouseResponse {
    public long user_id;
    public OffsetDateTime product_release_date; // pode ser null
    public String id;
    public List<Location> locations;

    public static class Location {
        public String store_id;
        public String network_node_id;
        public String type;
        public int quantity;
    }
}
