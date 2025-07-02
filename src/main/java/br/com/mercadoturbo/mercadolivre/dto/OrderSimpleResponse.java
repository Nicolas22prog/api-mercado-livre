package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderSimpleResponse extends ProxyEnabledDTO {
    public Long id;
    public String date_created;
    public String last_updated;
    public String date_closed;
    public String pack_id;
    public Boolean fulfilled;
    public String buying_mode;
    public BigDecimal shipping_cost;
    public List<Object> mediations;
    public BigDecimal total_amount;
    public BigDecimal paid_amount;
    public List<OrderItem> order_items;
    public String currency_id;
    public List<Payment> payments;
    public Shipping shipping;
    public String status;
    public String status_detail;
    public List<String> tags;
    public List<Object> internal_tags;
    public Feedback feedback;
    public Context context;
    public Seller seller;
    public Buyer buyer;
    public Taxes taxes;
    public Object cancel_detail;
    public String manufacturing_ending_date;
    public OrderRequest order_request;

    public static class OrderItem {
        public Item item;
        public Integer quantity;
        public RequestedQuantity requested_quantity;
        public String picked_quantity;
        public BigDecimal unit_price;
        public BigDecimal full_unit_price;
        public String full_unit_price_currency_id;
        public String currency_id;
        public String manufacturing_days;
        public BigDecimal sale_fee;
        public String listing_type_id;
        public String base_exchange_rate;
        public String base_currency_id;
        public Integer element_id;
        public Object discounts;
        public Object bundle;
        public Object compat_id;
        public Object stock;
        public Object kit_instance_id;
    }

    public static class Item {
        public String id;
        public String title;
        public String category_id;
        public Long variation_id;
        public String seller_custom_field;
        public List<VariationAttribute> variation_attributes;
        public String warranty;
        public String condition;
        public String seller_sku;
        public BigDecimal global_price;
        public BigDecimal net_weight;
        public String user_product_id;
        public String release_date;
    }

    public static class VariationAttribute {
        public String name;
        public String id;
        public String value_id;
        public String value_name;
    }

    public static class RequestedQuantity {
        public String measure;
        public Integer value;
    }

    public static class Payment {
        public Long id;
        public Long order_id;
        public Long payer_id;
        public Collector collector;
        public String card_id;
        public String reason;
        public String site_id;
        public String payment_method_id;
        public String currency_id;
        public Integer installments;
        public String issuer_id;
        public AtmTransferReference atm_transfer_reference;
        public String coupon_id;
        public String activation_uri;
        public String operation_type;
        public String payment_type;
        public List<String> available_actions;
        public String status;
        public String status_code;
        public String status_detail;
        public BigDecimal transaction_amount;
        public BigDecimal transaction_amount_refunded;
        public BigDecimal taxes_amount;
        public BigDecimal shipping_cost;
        public BigDecimal coupon_amount;
        public BigDecimal overpaid_amount;
        public BigDecimal total_paid_amount;
        public BigDecimal installment_amount;
        public String deferred_period;
        public String date_approved;
        public String transaction_order_id;
        public String date_created;
        public String date_last_modified;
        public BigDecimal marketplace_fee;
        public String reference_id;
        public String authorization_code;
    }

    public static class Collector {
        public Long id;
    }

    public static class AtmTransferReference {
        public String transaction_id;
        public String company_id;
    }

    public static class Shipping {
        public Long id;
    }

    public static class Feedback {
        public SellerFeedback seller;
        public Object buyer;
    }

    public static class SellerFeedback {
        public Long id;
    }

    public static class Context {
        public String channel;
        public String site;
        public List<String> flows;
    }

    public static class Seller {
        public Long id;
    }

    public static class Buyer {
        public Long id;
        public String nickname;
        public String first_name;
        public String last_name;
    }

    public static class Taxes {
        public BigDecimal amount;
        public String currency_id;
        public String id;
    }

    public static class OrderRequest {
        public String change;
        public String _return;
    }
}
