package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class NotaFiscalResponse extends ProxyEnabledDTO{
    public String id;
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
    public List<Object> errors;
    public Integer items_quantity;

    public static class Issuer {
        public String name;
        public Identifications identifications;
        public Phone phone;
        public Address address;
        public String user_id;
        public String brand_name;
    }

    public static class Identifications {
        public String cnpj;
        public String crt;
        public String ie;
        public String ie_type;
        public String cpf;
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

    public static class Recipient {
        public String name;
        public Identifications identifications;
        public Phone phone;
        public Address address;
        public String external_recipient_id;
    }

    public static class Shipment {
        public String id;
        public String site_id;
        public String mode;
        public String logistic_type;
        public BigDecimal buyer_cost;
        public String paid_by;
        public Carrier carrier;
        public List<Volume> volumes;
        public String fiscal_model_id;
    }

    public static class Carrier {
        public String name;
        public Identifications identifications;
        public Phone phone;
        public Address address;
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
        public FiscalDataItem fiscal_data;
    }

    public static class ItemAttributes {
        public String ean;
        public String sku;
        public String type;
    }

    public static class FiscalDataItem {
        public FiscalAttributes attributes;
        public List<Message> messages;
        public List<Rule> rules;
    }

    public static class FiscalAttributes {
        public String ncm;
        public String cest;
        public String origin_type;
        public String origin_detail;
        public String cfop;
        public String measurement_unit;
    }

    public static class Message {
        public String type;
        public String content;
    }

    public static class Rule {
        public String name;
        public RuleAttributes attributes;
    }

    public static class RuleAttributes {
        public BigDecimal municipal_tax;
        public BigDecimal vibpt;
        public BigDecimal pibpt;
        public BigDecimal federal_national_tax;
        public String messages;
        public BigDecimal federal_imported_tax;
        public BigDecimal state_tax;
        public String csosn;
        public BigDecimal vcofins;
        public BigDecimal pcofins;
        public String cst;
        public BigDecimal vbc;
        public BigDecimal vpis;
        public BigDecimal ppis;
        public BigDecimal vbcst;
        public BigDecimal vst;
        public BigDecimal vicms;
        public BigDecimal vicmsdeson;
        public BigDecimal vtottrib;
        public BigDecimal amount;
    }

    public static class Attributes {
        public String cnf;
        public String order_source;
        public String invoice_key;
        public String environment_type;
        public String xml_version;
        public Integer status_code;
        public String status_description;
        public String receipt;
        public String receipt_date;
        public String invoice_creation_date;
        public String protocol;
        public String invoice_type;
        public String emission_type;
        public String authorization_date;
        public String cancellation_protocol;
        public String cancellation_date;
        public String cancellation_reason;
        public Integer cancellation_error_code;
        public String cancellation_error_description;
        public String correction_letter;
        public Object reference_invoice;
        public Object reference_invoices;
        public String danfe_location;
        public String xml_location;
        public Boolean include_freight;
    }

    public static class FiscalData {
        public String customer_type;
        public String transaction_type;
        public String transaction_type_description;
        public List<Message> messages;
        public List<FiscalAmount> fiscal_amounts;
    }

    public static class FiscalAmount {
        public String name;
        public FiscalAmountAttributes attributes;
    }

    public static class FiscalAmountAttributes {
        public BigDecimal vpis;
        public BigDecimal vtottrib;
        public BigDecimal vbcst;
        public BigDecimal vst;
        public BigDecimal vicms;
        public BigDecimal vbc;
        public BigDecimal vicmsdeson;
        public BigDecimal vcofins;
        public BigDecimal pcofins;
        public BigDecimal amount;
    }
}
