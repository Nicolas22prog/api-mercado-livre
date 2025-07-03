package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class PartialRefoundResponse extends ProxyEnabledDTO{
    public String currency_id;
    public List<Offer> available_offers;
    public List<Recommendation> recommendations;

    public static class Offer {
        public Double amount;
        public Double percentage;
    }

    public static class Recommendation {
        public Double percentage;
        public String reason;
        public String type;
        public List<Restriction> restrictions;
    }

    public static class Restriction {
        public Double percentage;
        public String reason;
        public String type;
    }
}
