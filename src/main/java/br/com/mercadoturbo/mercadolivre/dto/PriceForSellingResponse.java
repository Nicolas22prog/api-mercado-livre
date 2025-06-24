package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;


public class PriceForSellingResponse extends ProxyEnabledDTO{
     public String currency_id;
    public boolean free_relist;
    public String listing_exposure;
    public BigDecimal listing_fee_amount;
    public ListingFeeDetails listing_fee_details;
    public String listing_type_id;
    public String listing_type_name;
    public boolean requires_picture;
    public BigDecimal sale_fee_amount;
    public SaleFeeDetails sale_fee_details;
    public String stop_time;

    public static class ListingFeeDetails {
        public BigDecimal fixed_fee;
        public BigDecimal gross_amount;
    }

    public static class SaleFeeDetails {
        public BigDecimal fixed_fee;
        public BigDecimal gross_amount;
        public BigDecimal percentage_fee;
    }
}


