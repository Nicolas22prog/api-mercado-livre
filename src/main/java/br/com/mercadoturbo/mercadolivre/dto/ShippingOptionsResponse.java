package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;

public class ShippingOptionsResponse {

    public Destination destination;
    public Option[] options;

    public static class Destination {
        // Se o destination vier com estrutura em outro cenário, defina aqui.
        // Neste JSON, ele é null.
    }

    public static class Option {
        public String id;
        public String name;
        public String currency_id;
        public BigDecimal list_cost;
        public BigDecimal cost;
        public String tracks_shipments_status;
        public String display;
        public Speed speed;
    }

    public static class Speed {
        // Se for um objeto no futuro, pode definir os campos aqui.
        // Neste JSON, o valor é null.
    }
}
