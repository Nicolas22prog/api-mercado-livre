package br.com.mercadoturbo.mercadolivre.dto;
import java.util.List;

public class ImageUploadResponse extends ProxyEnabledDTO{
    public String id;
    public List<Variation> variations;

    public static class Variation {
        public String size;
        public String url;
        public String secure_url;
    }
}