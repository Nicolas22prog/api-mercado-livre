package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ShipmentResponse extends ProxyEnabledDTO{

    public Long id;
    public String external_reference;
    public String status;
    public String substatus;
    public OffsetDateTime date_created;
    public OffsetDateTime last_updated;
    public BigDecimal declared_value;
    public Dimensions dimensions;
    public Logistic logistic;
    public Source source;
    public String tracking_number;
    public Origin origin;
    public Destination destination;
    public LeadTime lead_time;
    public String[] tags;

    public static class Dimensions {
        public Integer height;
        public Integer width;
        public Integer length;
        public Integer weight;
    }

    public static class Logistic {
        public String direction;
        public String mode;
        public String type;
    }

    public static class Source {
        public String site_id;
        public String market_place;
        public Long application_id;
    }

    public static class Origin {
        public String type;
        public Long sender_id;
        public ShippingAddress shipping_address;
    }

    public static class Destination {
        public String type;
        public Long receiver_id;
        public String receiver_name;
        public String receiver_phone;
        public String comments;
        public ShippingAddress shipping_address;
    }

    public static class ShippingAddress {
        public Long address_id;
        public String address_line;
        public String street_name;
        public String street_number;
        public String comment;
        public String zip_code;
        public City city;
        public State state;
        public Country country;
        public Neighborhood neighborhood;
        public Municipality municipality;
        public Agency agency;
        public String[] types;
        public Double latitude;
        public Double longitude;
        public String geolocation_type;
        public String delivery_preference;
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

    public static class Neighborhood {
        public String id;
        public String name;
    }

    public static class Municipality {
        public String id;
        public String name;
    }

    public static class Agency {
        public Long carrier_id;
        public Long agency_id;
        public String description;
        public String phone;
        public String open_hours;
    }

    public static class LeadTime {
        public Long option_id;
        public ShippingMethod shipping_method;
        public String currency_id;
        public BigDecimal cost;
        public BigDecimal list_cost;
        public String cost_type;
        public Integer service_id;
        public String delivery_type;
        public EstimatedDate estimated_schedule_limit;
        public EstimatedDeliveryTime estimated_delivery_time;
        public EstimatedDate estimated_delivery_limit;
        public EstimatedDate estimated_delivery_final;
        public EstimatedDate estimated_delivery_extended;
        public EstimatedDate estimated_handling_limit;
        public String[] delay;
    }

    public static class ShippingMethod {
        public Integer id;
        public String name;
        public String type;
        public String deliver_to;
    }

    public static class EstimatedDate {
        public OffsetDateTime date;
        public Integer offset;
    }

    public static class EstimatedDeliveryTime {
        public String type;
        public OffsetDateTime date;
        public String unit;
        public Offset offset;
        public TimeFrame time_frame;
        public OffsetDateTime pay_before;
        public Integer shipping;
        public Integer handling;
        public OffsetDateTime schedule;
    }

    public static class Offset {
        public OffsetDateTime date;
        public Integer shipping;
    }

    public static class TimeFrame {
        public OffsetDateTime from;
        public OffsetDateTime to;
    }
}
