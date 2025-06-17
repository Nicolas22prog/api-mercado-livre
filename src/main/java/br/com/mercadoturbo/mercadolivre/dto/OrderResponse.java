package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class OrderResponse extends ProxyEnabledDTO {


    public String query;
    public List<OrderDto> results;

    public static class OrderDto {

        public String status_code;
        public String status_detail;
        public BigDecimal total_amount;
        public BigDecimal paid_amount;
        public String currency_id;
        public OffsetDateTime date_created;
        public OffsetDateTime date_closed;
        public OffsetDateTime last_updated;
        public OffsetDateTime expiration_date;
        public Long id;
        public List<String> tags;
        public Buyer buyer;
        public Seller seller;
        public List<Payment> payments;
        public List<OrderItem> order_items;
        public Shipping shipping;
        public Context context;
        public Feedback feedback;
        public Coupon coupon;

        public static class Buyer {
            public Long id;
            public String nickname;
        }

        public static class Seller {
            public Long id;
            public String nickname;
        }

        public static class Payment {
            public Long id;
            public String reason;
            public String status;
            public String status_detail;
            public String payment_method_id;
            public String payment_type;
            public BigDecimal transaction_amount;
            public BigDecimal total_paid_amount;
            public BigDecimal transaction_amount_refunded;
            public BigDecimal shipping_cost;
            public BigDecimal installment_amount;
            public Integer installments;
            public OffsetDateTime date_approved;
            public OffsetDateTime date_created;
            public OffsetDateTime date_last_modified;
            public Collector collector;
            public AtmTransferReference atm_transfer_reference;
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

        public static class OrderItem {
            public Item item;
            public Integer quantity;
            public BigDecimal unit_price;
            public BigDecimal full_unit_price;
            public String currency_id;
            public RequestedQuantity requested_quantity;
            public BigDecimal sale_fee;
            public String listing_type_id;
            public Integer element_id;
        }

        public static class Item {
            public String id;
            public String title;
            public String category_id;
            public String seller_custom_field;
            public String condition;
            public String warranty;
            public String seller_sku;
            public Long variation_id;
            public List<VariationAttribute> variation_attributes;
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

        public static class Context {
            public String application;
            public String product_id;
            public String channel;
            public String site;
            public List<String> flows;
        }

        public static class Feedback {
            public Sale sale;
            public Seller seller;
            public Buyer buyer;
        }

        public static class Sale {
            public Long id;
            public OffsetDateTime date_created;
            public Boolean fulfilled;
            public String status;
            public String rating;
        }

        public static class Coupon {
            public BigDecimal amount;
            public String id;
        }
    }
}

