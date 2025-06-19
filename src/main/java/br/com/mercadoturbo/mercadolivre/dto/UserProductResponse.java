package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class UserProductResponse extends ProxyEnabledDTO {

    public String family_name;
    public String site_id;
    public Long user_id;
    public String domain_id;
    public String catalog_product_id;
    public String bundle;
    public Long family_id;
    public OffsetDateTime date_created;
    public OffsetDateTime last_updated;
    public List<MainFeature> main_features;
    public String id;
    public String name;
    public List<Attribute> attributes;
    public List<Picture> pictures;
    public Thumbnail thumbnail;
    public List<String> tags;
    public String commingling;

    public static class MainFeature {
        // Está vindo vazio, mas se quiser deixar preparado:
        public String id;
        public String name;
        public List<Value> values;
    }

    public static class Attribute {
        public String id;
        public String name;
        public List<Value> values;
    }

    public static class Value {
        public String id;
        public String name;
        public Struct struct;
    }

    public static class Struct {
        public Double number;
        public String unit;
    }

    public static class Picture {
        public String secure_url;
        public String id;
    }

    public static class Thumbnail {
        public String secure_url;
        public String id;
    }
}
