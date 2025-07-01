package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class ShipmentDocumentsResponse extends ProxyEnabledDTO {
    public Receiver receiver;
    public List<Sender> senders;
    public Carrier carrier;

    public static class Receiver {
        public Long id;
        public Document document;
        public String city_ibge;
        public List<AdditionalDocument> additional_documents;
        public String name;
        public BillingAddress billing_address;
    }

    public static class Sender {
        public Long id;
        public Document document;
        public String city_ibge;
        public List<AdditionalDocument> additional_documents;
        public String name;
    }

    public static class Carrier {
        public Document document;
        public List<AdditionalDocumentCarrier> additional_documents;
    }

    public static class Document {
        public String id;
        public String value;
    }

    public static class AdditionalDocument {
        public String type;
        public String value;
    }

    public static class AdditionalDocumentCarrier {
        public String id;
        public String value;
    }

    public static class BillingAddress {
        public String street_name;
        public String street_number;
        public String zip_code;
        public String comment;
        public City city;
        public State state;
        public Country country;
        public Neighborhood neighborhood;
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
}