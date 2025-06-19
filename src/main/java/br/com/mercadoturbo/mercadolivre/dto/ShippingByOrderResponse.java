package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


public class ShippingByOrderResponse extends ProxyEnabledDTO {
    
    
        public SubstatusHistory[] substatus_history;
        public SnapshotPacking snapshot_packing;
        public Long receiver_id;
        public BigDecimal base_cost;
        public StatusHistory status_history;
        public String type;
        public Object return_details;
        public Long sender_id;
        public String mode;
        public BigDecimal order_cost;
        public PriorityClass priority_class;
        public Integer service_id;
        public ShippingItem[] shipping_items;
        public String tracking_number;
        public CostComponents cost_components;
        public Long id;
        public String tracking_method;
        public OffsetDateTime last_updated;
        public String[] items_types;
        public String comments;
        public String substatus;
        public OffsetDateTime date_created;
        public OffsetDateTime date_first_printed;
        public String created_by;
        public Long application_id;
        public ShippingOption shipping_option;
        public String[] tags;
        public Address sender_address;
        public Sibling sibling;
        public String return_tracking_number;
        public String site_id;
        public Object carrier_info;
        public String market_place;
        public Address receiver_address;
        public Long customer_id;
        public Long order_id;
        public Object quotation;
        public String status;
        public String logistic_type;

        public static class SubstatusHistory {
            public OffsetDateTime date;
            public String substatus;
            public String status;
        }

        public static class SnapshotPacking {
            public String snapshot_id;
            public String pack_hash;
        }

        public static class StatusHistory {
            public OffsetDateTime date_shipped;
            public OffsetDateTime date_returned;
            public OffsetDateTime date_delivered;
            public OffsetDateTime date_first_visit;
            public OffsetDateTime date_not_delivered;
            public OffsetDateTime date_cancelled;
            public OffsetDateTime date_handling;
            public OffsetDateTime date_ready_to_ship;
        }

        public static class PriorityClass {
            public String id;
        }

        public static class ShippingItem {
            public Integer quantity;
            public DimensionsSource dimensions_source;
            public String description;
            public String id;
            public Object bundle;
            public Object user_product_id;
            public Long sender_id;
            public String dimensions;
        }

        public static class DimensionsSource {
            public String origin;
            public String id;
        }

        public static class CostComponents {
            public BigDecimal loyal_discount;
            public BigDecimal special_discount;
            public BigDecimal compensation;
            public BigDecimal gap_discount;
            public BigDecimal ratio;
        }

        public static class ShippingOption {
            public Integer processing_time;
            public BigDecimal cost;
            public EstimatedDate estimated_schedule_limit;
            public Long shipping_method_id;
            public EstimatedOffsetDate estimated_delivery_final;
            public EstimatedDate buffering;
            public TimeFrame pickup_promise;
            public BigDecimal list_cost;
            public EstimatedOffsetDate estimated_delivery_limit;
            public PriorityClass priority_class;
            public String delivery_promise;
            public String delivery_type;
            public EstimatedDeliveryTime estimated_delivery_time;
            public String name;
            public Long id;
            public EstimatedOffsetDate estimated_delivery_extended;
            public String currency_id;
        }

        public static class EstimatedDate {
            public OffsetDateTime date;
        }

        public static class EstimatedOffsetDate {
            public OffsetDateTime date;
            public Integer offset;
        }

        public static class EstimatedDeliveryTime {
            public OffsetDateTime date;
            public OffsetDateTime pay_before;
            public OffsetDateTime schedule;
            public String unit;
            public Offset offset;
            public Integer shipping;
            public TimeFrame time_frame;
            public Integer handling;
            public String type;
        }

        public static class Offset {
            public OffsetDateTime date;
            public Integer shipping;
        }

        public static class TimeFrame {
            public OffsetDateTime from;
            public OffsetDateTime to;
        }

        public static class Address {
            public Country country;
            public String address_line;
            public String[] types;
            public Object scoring;
            public Object agency;
            public City city;
            public String geolocation_type;
            public Double latitude;
            public Municipality municipality;
            public Long location_id;
            public String street_name;
            public String zip_code;
            public Node node;
            public Object intersection;
            public String street_number;
            public String comment;
            public Long id;
            public State state;
            public Neighborhood neighborhood;
            public OffsetDateTime geolocation_last_updated;
            public Double longitude;
            public String geolocation_source;
            public String delivery_preference;
            public String receiver_name;
            public String receiver_phone;
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

        public static class Node {
            public String logistic_center_id;
            public String node_id;
        }

        public static class Sibling {
            public String reason;
            public Long sibling_id;
            public String description;
            public String source;
            public OffsetDateTime date_created;
            public OffsetDateTime last_updated;
        }
}
