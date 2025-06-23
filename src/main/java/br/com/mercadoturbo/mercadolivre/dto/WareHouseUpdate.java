package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class WareHouseUpdate {
    public List<Location> locations;

    public static class Location {
        public String store_id;
        public String network_node_id; // opcional, não validado
        public int quantity;
    }
}
