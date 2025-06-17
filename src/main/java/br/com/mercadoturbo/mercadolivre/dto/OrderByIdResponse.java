package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class OrderByIdResponse extends ProxyEnabledDTO{

    public String query;
    public String display;
    public Paging paging;
    public List<Result> results;
    public Sort sort;
    public List<AvailableSort> available_sorts;
    public List<Object> filters;
    public List<AvailableFilter> available_filters;

    public static class Paging {
        public Integer total;
        public Integer offset;
        public Integer limit;
    }

    public static class Result {
        public Long id;
        public Object comments;
        public String status_code;
        public StatusDetail status_detail;
        public OffsetDateTime date_created;
        public OffsetDateTime date_closed;
        public OffsetDateTime expiration_date;
        public OffsetDateTime date_last_updated;
        public Boolean hidden_for_seller;
        public String currency_id;
        public List<OrderItem> order_items;
        public BigDecimal total_amount;
        public List<Object> mediations;
        public List<Payment> payments;
        public Shipping shipping;
        public Buyer buyer;
        public Seller seller;
        public Feedback feedback;
        public List<String> tags;
    }

    public static class StatusDetail {
        public String description;
        public String code;
    }

    public static class OrderItem {
        public String currency_id;
        public Item item;
        public BigDecimal sale_fee;
        public Integer quantity;
        public BigDecimal unit_price;
    }

    public static class Item {
        public String id;
        public String title;
        public String seller_custom_field;
        public List<Object> variation_attributes;
        public String category_id;
        public Long variation_id;
    }

    public static class Payment {
        public Long id;
        public Long order_id;
        public Long payer_id;
        public Collector collector;
        public String currency_id;
        public String status;
        public String status_code;
        public String status_detail;
        public BigDecimal transaction_amount;
        public BigDecimal shipping_cost;
        public BigDecimal overpaid_amount;
        public BigDecimal total_paid_amount;
        public BigDecimal marketplace_fee;
        public BigDecimal coupon_amount;
        public OffsetDateTime date_created;
        public OffsetDateTime date_last_modified;
        public Long card_id;
        public String reason;
        public String activation_uri;
        public String payment_method_id;
        public Integer installments;
        public String issuer_id;
        public AtmTransferReference atm_transfer_reference;
        public String coupon_id;
        public String operation_type;
        public String payment_type;
        public List<Object> available_actions;
        public BigDecimal installment_amount;
        public String deferred_period;
        public OffsetDateTime date_approved;
        public String authorization_code;
        public String transaction_order_id;
    }

    public static class Collector {
        public Long id;
    }

    public static class AtmTransferReference {
        public String company_id;
        public String transaction_id;
    }

    public static class Shipping {
        public String substatus;
        public String status;
        public Long id;
        public Integer service_id;
        public String currency_id;
        public String shipping_mode;
        public String shipment_type;
        public Long sender_id;
        public String picking_type;
        public ReceiverAddress receiver_address;
        public OffsetDateTime date_created;
        public BigDecimal cost;
        public OffsetDateTime date_first_printed;
        public ShippingOption shipping_option;
        public List<ShippingItem> shipping_items;
    }

    public static class ReceiverAddress {
        public Long id;
        public String zip_code;
        public String latitude;
        public String longitude;
        public String street_number;
        public String street_name;
        public State state;
        public String comment;
        public String address_line;
        public Country country;
        public City city;
    }

    public static class State {
        public String id;
        public String name;
    }

    public static class Country {
        public String id;
        public String name;
    }

    public static class City {
        public String id;
        public String name;
    }

    public static class ShippingOption {
        public Long id;
        public Long shipping_method_id;
        public String name;
        public String currency_id;
        public BigDecimal cost;
        public Speed speed;
        public EstimatedDelivery estimated_delivery;
    }

    public static class Speed {
        public Integer shipping;
        public Integer handling;
    }

    public static class EstimatedDelivery {
        public OffsetDateTime date;
        public String time_from;
        public String time_to;
    }

    public static class ShippingItem {
        public String id;
        public String description;
        public Integer quantity;
        public String dimensions;
    }

    public static class Buyer {
        public Long id;
        public String nickname;
        public String first_name;
        public String last_name;
        public String email;
        public Phone phone;
        public Phone alternative_phone;
        public BillingInfo billing_info;
    }

    public static class Seller {
        public Long id;
        public String nickname;
        public String email;
        public SellerPhone phone;
        public Phone alternative_phone;
        public String first_name;
        public String last_name;
    }

    public static class Phone {
        public String area_code;
        public String number;
        public String extension;
    }

    public static class SellerPhone extends Phone {
        public Boolean verified;
    }

    public static class BillingInfo {
        public String doc_type;
        public String doc_number;
    }

    public static class Feedback {
        public FeedbackDetail sale;
        public FeedbackDetail purchase;
    }

    public static class FeedbackDetail {
        public Long id;
        public OffsetDateTime date_created;
        public Boolean fulfilled;
        public String rating;
        public String status;
    }

    public static class Sort {
        public String id;
        public String name;
    }

    public static class AvailableSort {
        public String id;
        public String name;
    }

    public static class AvailableFilter {
        public String id;
        public String name;
        public String type;
        public List<FilterValue> values;
    }

    public static class FilterValue {
        public String id;
        public String name;
        public Integer results;
    }
}
