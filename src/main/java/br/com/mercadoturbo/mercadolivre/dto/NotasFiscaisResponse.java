package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class NotasFiscaisResponse extends ProxyEnabledDTO {
    public Integer id;
    public String status;
    public String transaction_status;
    public Issuer issuer;
    public Recipient recipient;
    public Shipment shipment;
    public List<Item> items;
    public OffsetDateTime issued_date;
    public String invoice_series;
    public Integer invoice_number;
    public Attributes attributes;
    public FiscalData fiscal_data;
    public BigDecimal amount;
    public BigDecimal items_amount;
    public List<Error> errors;
    public Integer items_quantity;
    public String pack_id;
    public String custom_issuer_address;
    public String site_id;

    public static class Issuer {
        public String user_id;
        public String brand_name;
        public String name;
        public Phone phone;
        public Address address;
        public Identifications identifications;
    }

    public static class Recipient {
        public String external_recipient_id;
        public String name;
        public Phone phone;
        public Address address;
        public Identifications identifications;
    }

    public static class Phone {
        public String area_code;
        public String number;
    }

    public static class Address {
        public String street_name;
        public String street_number;
        public String complement;
        public String neighborhood;
        public String city;
        public String zip_code;
        public String state;
        public String country;
    }

    public static class Identifications {
        public String cnpj;
        public String crt;
        public String ie;
        public String ie_type;
    }

    public static class Shipment {
        public Integer id;
        public String site_id;
        public String mode;
        public String logistic_type;
        public BigDecimal buyer_cost;
        public String paid_by;
        public Carrier carrier;
        public List<Volume> volumes;
        public String fiscal_model_id;
        public String status;
    }

    public static class Carrier {
        public String name;
        public Phone phone;
        public Address address;
        public Identifications identifications;
    }

    public static class Volume {
        public BigDecimal net_weight;
        public BigDecimal gross_weight;
    }

    public static class Item {
        public String id;
        public String invoice_id;
        public String seller_id;
        public String external_order_id;
        public String external_product_id;
        public String external_variant_id;
        public ItemAttributes attributes;
        public String product_name;
        public Integer quantity;
        public BigDecimal total_amount;
        public BigDecimal shipping_buyer_cost;
        public BigDecimal discount_amount;
        public Object fiscal_data;
    }

    public static class ItemAttributes {
        public String ean;
        public String sku;
        public String type;
        public Integer bundle_quantity;
    }

    public static class Attributes {
        public String order_source;
        public String invoice_source;
        public String invoice_key;
        public String environment_type;
        public String xml_version;
        public String status_code;
        public String status_description;
        public String receipt;
        public OffsetDateTime receipt_date;
        public OffsetDateTime invoice_creation_date;
        public String protocol;
        public String invoice_type;
        public String emission_type;
        public OffsetDateTime authorization_date;
        public String cancellation_protocol;
        public OffsetDateTime cancellation_date;
        public String cancellation_reason;
        public Integer cancellation_error_code;
        public String cancellation_error_description;
        public String danfe;
        public String document;
        public String cnf;
        public String correction_letter;
        public ReferenceInvoice reference_invoice;
        public List<ReferenceInvoice> reference_invoices;
        public String danfe_location;
        public String xml_location;
        public Boolean include_freight;
    }

    public static class ReferenceInvoice {
        public Integer id;
        public String invoice_key;
    }

    public static class FiscalData {
        public String customer_type;
        public String transaction_type;
        public String transaction_type_description;
        public List<Message> messages;
        public List<FiscalAmount> fiscal_amounts;
        public String state_calculation_type;
    }

    public static class Message {
        public String type;
        public String content;
    }

    public static class FiscalAmount {
        public String name;
        public Object attributes;
    }

    public static class Error {
        public String code;
        public String description;
        public String type;
        public String source;
        public String target;
    }
}
