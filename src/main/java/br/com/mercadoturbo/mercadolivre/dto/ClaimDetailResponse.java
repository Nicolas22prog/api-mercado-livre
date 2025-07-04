package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class ClaimDetailResponse extends ProxyEnabledDTO{
       public Long id;
    public String last_updated;
    public List<Shipment> shipments;
    public String refund_at;
    public String date_closed;
    public String resource_type;
    public String date_created;
    public Long claim_id;
    public String status_money;
    public Long resource_id;
    public List<Order> orders;
    public String subtype;
    public String status;
    public List<String> related_entities;
    public Boolean intermediate_check;

    public static class Shipment {
        public long shipment_id;
        public String status;
        public String tracking_number;
        public Destination destination;
        public String type;

        public static class Destination {
            public String name;
            public ShippingAddress shipping_address;

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
            }
        }
    }

    public static class Order {
        public Long order_id;
        public String item_id;
        public String variation_id;
        public String context_type;
        public String total_quantity;
        public String return_quantity;
    }
}
