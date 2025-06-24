package br.com.mercadoturbo.mercadolivre.dto;


public class ImageDiagRequest {
    public String id;          // Pode ser UUID em formato String ou null
    public String picture_url;
    public Context context;

    public static class Context {
        public String category_id;
        public String title;
    }
}
