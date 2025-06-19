package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PostItemResponse extends ProxyEnabledDTO{

    public String id;
    public String site_id;
    public String title;
    public String family_name;
    public Long seller_id;
    public String category_id;
    public String user_product_id;
    public Long official_store_id;
    public BigDecimal price;
    public BigDecimal base_price;
    public BigDecimal original_price;
    public String inventory_id;
    public String currency_id;
    public Integer initial_quantity;
    public Integer available_quantity;
    public Integer sold_quantity;
    public SaleTerm[] sale_terms;
    public String buying_mode;
    public String listing_type_id;
    public OffsetDateTime start_time;
    public OffsetDateTime stop_time;
    public OffsetDateTime end_time;
    public OffsetDateTime expiration_time;
    public String condition;
    public String permalink;
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
    public String thumbnail_id;
    public String thumbnail;
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
    public Object health;
    public Boolean catalog_listing;
    public Object[] item_relations;
    public String[] channels;

    public static class SaleTerm {
        public String id;
        public String value_name;
    }

    public static class Picture {
        public String id;
        public String url;
        public String secure_url;
        public String size;
        public String max_size;
        public String quality;
    }

    public static class Description {
        public String id;
    }

    public static class PaymentMethod {
        public String id;
        public String name;
    }

    public static class Shipping {
        public Boolean free_shipping;
        public String mode;
        public String logistic_type;
        public Boolean store_pick_up;
        public ShippingOption options[];
    }

    public static class ShippingOption {
        public String id;
        public String name;
        public BigDecimal cost;
        public EstimatedDeliveryTime estimated_delivery_time;
    }

    public static class EstimatedDeliveryTime {
        public OffsetDateTime date;
        public Integer offset;
    }

    public static class SellerAddress {
        public String id;
        public String comment;
        public String address_line;
        public String zip_code;
        public Country country;
        public State state;
        public City city;
        public Neighborhood neighborhood;
        public Municipality municipality;
        public String latitude;
        public String longitude;
    }

    public static class Country {
        public String id;
        public String name;
    }

    public static class State {
        public String id;
        public String name;
    }

    public static class City {
        public String id;
        public String name;
    }

    public static class Neighborhood {
        public String id;
        public String name;
    }

    public static class Municipality {
        public String id;
        public String name;
    }

    public static class Location {
        public String address_line;
        public String zip_code;
        public Country country;
        public State state;
        public City city;
    }

    public static class Geolocation {
        public Double latitude;
        public Double longitude;
    }

    public static class Attribute {
        public String id;
        public String name;
        public String value_id;
        public String value_name;
        public String attribute_group_id;
        public String attribute_group_name;
    }

    public static class Warning {
        public String code;
        public String message;
    }

    public static class Variation {
        public String id;
        public BigDecimal price;
        public Integer available_quantity;
        public Attribute[] attributes;
        public Picture[] pictures;
        public SaleTerm[] sale_terms;
    }
}
