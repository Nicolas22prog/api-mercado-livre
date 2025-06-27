package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class VariationFullResponse {
    public Long id;
    public String site_id;
    public String title;
    public String subtitle;
    public Long seller_id;
    public String category_id;
    public Long official_store_id;
    public BigDecimal price;
    public BigDecimal base_price;
    public BigDecimal original_price;
    public String currency_id;
    public Integer initial_quantity;
    public Integer available_quantity;
    public Integer sold_quantity;
    public String buying_mode;
    public String listing_type_id;
    public OffsetDateTime start_time;
    public OffsetDateTime stop_time;
    public OffsetDateTime end_time;
    public OffsetDateTime expiration_time;
    public String condition;
    public String permalink;
    public String thumbnail;
    public String secure_thumbnail;
    public Picture[] pictures;
    public String video_id;
    public Description[] descriptions;
    public Boolean accepts_mercadopago;
    public PaymentMethod[] non_mercado_pago_payment_methods;
    public Shipping shipping;
    public String international_delivery_mode;
    public SellerAddress seller_address;
    public Object seller_contact;
    public Location location;
    public Geolocation geolocation;
    public Object[] coverage_areas;
    public Attribute[] attributes;
    public Warning[] warnings;
    public String listing_source;
    public Variation[] variations;
    public String status;
    public String[] sub_status;
    public String[] tags;
    public String warranty;
    public String catalog_product_id;
    public String domain_id;
    public String seller_custom_field;
    public String parent_item_id;
    public Object differential_pricing;
    public String[] deal_ids;
    public Boolean automatic_relist;
    public OffsetDateTime date_created;
    public OffsetDateTime last_updated;

    public static class AttributeCombination {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public Object value_struct;
        public Value[] values;
    }

    public static class Attribute {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public String attribute_group_id;
        public String attribute_group_name;
        public Object value_struct;
        public Value[] values;
    }

    public static class Value {
        public String id;
        public String name;
        public Object struct;
    }

    public static class Picture {
        public String id;
        public String url;
        public String secure_url;
        public String size;
        public String max_size;
        public String quality;
        public String source;
    }

    public static class Description {
        public String id;
    }

    public static class PaymentMethod {
        public String id;
        public String name;
    }

    public static class Shipping {
        public String mode;
        public Boolean local_pick_up;
        public Boolean free_shipping;
        public String[] methods;
        public String dimensions;
        public String[] tags;
        public String logistic_type;
    }

    public static class SellerAddress {
        public Long id;
        public String comment;
        public String address_line;
        public String zip_code;
        public City city;
        public State state;
        public Country country;
        public String latitude;
        public String longitude;
        public SearchLocation search_location;
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
        public Neighborhood neighborhood;
        public City city;
        public State state;
    }

    public static class Neighborhood {
        public String id;
        public String name;
    }

    public static class Location {
    }

    public static class Geolocation {
        public String latitude;
        public String longitude;
    }

    public static class Warning {
        public String code;
        public String message;
    }

    public static class Variation {
        public Long id;
        public AttributeCombination[] attribute_combinations;
        public BigDecimal price;
        public Integer available_quantity;
        public Integer sold_quantity;
        public String[] picture_ids;
        public String seller_custom_field;
        public String catalog_product_id;
        public Attribute[] attributes;
    }
}
