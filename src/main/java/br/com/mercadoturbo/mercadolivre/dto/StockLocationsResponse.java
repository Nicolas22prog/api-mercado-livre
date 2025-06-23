package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class StockLocationsResponse extends ProxyEnabledDTO{

    public Paging paging;
    public List<Result> results;

    public static class Paging {
        public int limit;
        public int total;
    }

    public static class Result {
        public String id;
        public String user_id;
        public String description;
        public String status;
        public Location location;
        public List<String> tags;
        public String network_node_id;
        public Services services;
    }

    public static class Location {
        public int address_id;
        public String address_line;
        public String street_name;
        public int street_number;
        public double latitude;
        public double longitude;
        public String city;
        public String state;
        public String country;
        public String zip_code;
    }

    public static class Services {
        public List<String> stock_location;
    }
}
