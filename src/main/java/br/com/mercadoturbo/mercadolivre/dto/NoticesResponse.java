package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

/**
 * Representa a resposta do endpoint /communications/notices do Mercado Livre.
 */
public class NoticesResponse extends ProxyEnabledDTO{
    public Paging paging;
    public List<Notice> results;
    
    
    public static class Paging {
        public int total;
        public int offset;
        public int limit;
    }

    public static class Notice {
        public List<Action> actions;      // pode ser null ou vazio
        public String id;
        public String label;
        public String title;              // pode estar presente em alguns retornos
        public String description;
        public Boolean highlighted;
        public String from_date;
        public List<Tag> tags;            // pode ser null ou vazio
        public String dismiss_key;        // pode estar presente em alguns retornos
        public String category;           // pode estar presente, conforme doc
        public String sub_category;       // pode estar presente, conforme doc

        public static class Action {
            public String text;
            public String link;
        }

        public static class Tag {
            public String tag;
            public String type;
        }
    }
}
