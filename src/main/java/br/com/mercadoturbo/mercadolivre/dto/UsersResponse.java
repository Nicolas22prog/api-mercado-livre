/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.dto;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;


public class UsersResponse extends ProxyEnabledDTO{
 
    public Long id;
    public String nickname;
    public OffsetDateTime registration_date;
    public String first_name;
    public String last_name;
    public String gender;
    public String country_id;
    public String email;
    public Identification identification;
    public Address address;
    public Phone phone;
    public AlternativePhone alternative_phone;
    public String user_type;
    public List<String> tags;
    public String logo;
    public Integer points;
    public String site_id;
    public String permalink;
    public String seller_experience;
    public BillData bill_data;
    public SellerReputation seller_reputation;
    public BuyerReputation buyer_reputation;
    public Status status;
    public String secure_email;
    public Company company;
    public Credit credit;
    public Context context;
    public Thumbnail thumbnail;
    public List<String> registration_identifiers;
    
    public static class Identification {
        public String number;
        public String type;
    }
    
    public static class Address {
        public String address;
        public String city;
        public String state;
        public String zip_code;
    }
    
    public static class Phone {
        public String area_code;
        public String extension;
        public String number;
        public Boolean verified;
    }
    
    public static class AlternativePhone {
        public String area_code;
        public String extension;
        public String number;
    }
    
    public static class BillData {
        public String accept_credit_note;
    }
    
    public static class SellerReputation {
        public String level_id;
        public String power_seller_status;
        public Transactions transactions;
        public Metrics metrics;
    }
    
    public static class Transactions {
        public Integer canceled;
        public Integer completed;
        public String period;
        public Ratings ratings;
        public Integer total;
    }
    
    public static class Ratings {
        public Integer negative;
        public Integer neutral;
        public Integer positive;
    }
    
    public static class Metrics {
        public Sales sales;
        public Claims claims;
        public DelayedHandlingTime delayed_handling_time;
        public Cancellations cancellations;
    }
    
    public static class Sales {
        public String period;
        public Integer completed;
    }
    
    public static class Claims {
        public String period;
        public Double rate;
        public Integer value;
    }
    
    public static class DelayedHandlingTime {
        public String period;
        public double rate;
        public int value;
    }
    
    public static class Cancellations {
        public String period;
        public double rate;
        public int value;
    }
    
    public static class BuyerReputation {
        public int canceled_transactions;
        public List<String> tags;
        public BuyerTransactions transactions;
    }
    
    public static class BuyerTransactions {
        public TransactionDetails canceled;
        public Integer completed;
        public TransactionDetails not_yet_rated;
        public String period;
        public Integer total;
        public TransactionDetails unrated;
    }
    
    public static class TransactionDetails {
        public Integer paid;
        public Integer total;
        public Integer units;
    }
    
    public static class Status {
        public StatusDetail billing;
        public BuyStatus buy;
        public boolean confirmed_email;
        public ShoppingCart shopping_cart;
        public boolean immediate_payment;
        public StatusDetail list;
        public String mercadoenvios;
        public String mercadopago_account_type;
        public boolean mercadopago_tc_accepted;
        public String required_action;
        public StatusDetail sell;
        public String site_status;
        public String user_type;
        public RestrictionsColiving restrictions_coliving;
    }
    
    public static class StatusDetail {
        public boolean allow;
        public List<String> codes;
        public ImmediatePayment immediate_payment;
    }
    
    public static class BuyStatus {
        public boolean allow;
        public List<String> codes;
        public ImmediatePayment immediate_payment;
    }
    
    public static class ImmediatePayment {
        public List<String> reasons;
        public boolean required;
    }
    
    public static class ShoppingCart {
        public String buy;
        public String sell;
    }
    
    public static class RestrictionsColiving {
        public String verification_status;
        public List<String> user_tags;
        public List<String> user_internal_tags;
        public List<String> user_status_attributes;
    }
    
    public static class Company {
        public String brand_name;
        public String city_tax_id;
        public String corporate_name;
        public String identification;
        public String state_tax_id;
        public String cust_type_id;
        public String soft_descriptor;
    }
    
    public static class Credit {
        public BigDecimal consumed;
        public String credit_level_id;
        public String rank;
    }
    
    public static class Context {
        public String ip_address;
    }
    
    public static class Thumbnail {
        public String picture_id;
        public String picture_url;
    }
}

