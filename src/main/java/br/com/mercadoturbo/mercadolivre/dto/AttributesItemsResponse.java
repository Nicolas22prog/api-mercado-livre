package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.util.List;


public class AttributesItemsResponse {
public String id;
    public String site_id;
    public String title;
    public String family_name;
    public Long seller_id;
    public String category_id;
    public String user_product_id;
    public String official_store_id;
    public BigDecimal price;
    public BigDecimal base_price;
    public BigDecimal original_price;
    public String inventory_id;
    public String currency_id;
    public int initial_quantity;
    public int available_quantity;
    public int sold_quantity;

    public List<SaleTerm> sale_terms;

    public String buying_mode;
    public String listing_type_id;
    public String start_time;
    public String stop_time;
    public String end_time;
    public String expiration_time;
    public String condition;
    public String permalink;
    public String thumbnail_id;
    public String thumbnail;

    public List<Picture> pictures;
    public String video_id;
    public List<Object> descriptions; // vazio no exemplo
    public boolean accepts_mercadopago;
    public List<Object> non_mercado_pago_payment_methods;

    public Shipping shipping;

    public String international_delivery_mode;
    public SellerAddress seller_address;
    public Object seller_contact;
    public Object location;

    public Geolocation geolocation;
    public List<Object> coverage_areas;

    public List<Attribute> attributes;

    public List<Object> warnings;
    public String listing_source;
    public List<Variation> variations;
    public String status;
    public List<String> sub_status;
    public List<String> tags;
    public String warranty;
    public String catalog_product_id;
    public String domain_id;
    public String seller_custom_field;
    public String parent_item_id;
    public Object differential_pricing;
    public List<Object> deal_ids;
    public boolean automatic_relist;
    public String date_created;
    public String last_updated;
    public double health;
    public boolean catalog_listing;
    public List<Object> item_relations;
    public List<String> channels;

    public static class SaleTerm {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public Struct value_struct;
        public List<Value> values;
        public String value_type;
    }

    public static class Value {
        public String id;
        public String name;
        public Struct struct;
    }

    public static class Struct {
        public int number;
        public String unit;
    }

    public static class Picture {
        public String id;
        public String url;
        public String secure_url;
        public String size;
        public String max_size;
        public String quality;
    }

    public static class Shipping {
        public String mode;
        public List<Object> methods;
        public List<String> tags;
        public String dimensions;
        public boolean local_pick_up;
        public boolean free_shipping;
        public String logistic_type;
        public boolean store_pick_up;
    }

    public static class SellerAddress {
        public String address_line;
        public String zip_code;
        public City city;
        public State state;
        public Country country;
        public SearchLocation search_location;
        public double latitude;
        public double longitude;
        public long id;
    }

    public static class City {
        public String id;
        public String name;
    }

    public static class State {
        public String id;
        public String name;
    }

    public static class Country {
        public String id;
        public String name;
    }

    public static class SearchLocation {
        public City city;
        public State state;
    }

    public static class Geolocation {
        public double latitude;
        public double longitude;
    }

    public static class Attribute {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public List<Value> values;
        public String value_type;
    }

    public static class Variation {
        public Long id;
        public BigDecimal price;
        public List<AttributeCombination> attribute_combinations;
        public int available_quantity;
        public int sold_quantity;
        public List<Object> sale_terms;
        public List<String> picture_ids;
        public String seller_custom_field;
        public String catalog_product_id;
        public String inventory_id;
        public List<Object> item_relations;
        public String user_product_id;
    }

    public static class AttributeCombination {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public List<Value> values;
        public String value_type;
    }
}
