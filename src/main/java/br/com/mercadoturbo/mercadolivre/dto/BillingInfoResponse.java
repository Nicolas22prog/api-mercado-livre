package br.com.mercadoturbo.mercadolivre.dto;

public class BillingInfoResponse extends ProxyEnabledDTO{
    public String site_id;
    public Buyer buyer;
    public Seller seller;

    public static class Buyer {
        public Long cust_id;
        public BillingInfo billing_info;
    }

    public static class BillingInfo {
        public String name;
        public String last_name;
        public Identification identification;
        public Address address;
        public Attributes attributes;
        public Taxes taxes;
    }

    public static class Identification {
        public String type;
        public String number;
    }

    public static class Address {
        public String street_name;
        public String street_number;
        public String city_name;
        public String comment;
        public String neighborhood;
        public State state;
        public String zip_code;
        public String country_id;
    }

    public static class State {
        public String name;
    }

    public static class Attributes {
        public Boolean is_normalized;
        public String cust_type;
    }

    public static class Taxes {
        public Inscriptions inscriptions;
        public TaxpayerType taxpayer_type;
    }

    public static class Inscriptions {
        public String state_registration;
    }

    public static class TaxpayerType {
        public String description;
    }

    public static class Seller {
        public Long cust_id;
    }
}
