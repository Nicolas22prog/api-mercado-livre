package br.com.mercadoturbo.mercadolivre.dto;




import java.time.OffsetDateTime;
import java.util.List;

public class AllQuestionsResponse  extends ProxyEnabledDTO{
    public Integer total;
    public Integer limit;
    public List<Question> questions;
    public Filters filters;
    public List<AvailableFilter> available_filters;
    public List<String> available_sorts;

    public static class Question {
        public OffsetDateTime date_created;
        public String item_id;
        public Long seller_id;
        public String status;
        public String text;
        public List<String> tags;
        public Long id;
        public Boolean deleted_from_listing;
        public Boolean hold;
        public Answer answer;
        public From from;

        public static class Answer {
            public String text;
            public String status;
            public OffsetDateTime date_created;
        }

        public static class From {
            public Long id;
        }
    }

    public static class Filters {
        public Integer limit;
        public Integer offset;
        public String api_version;
        public Boolean is_admin;
        public List<String> sorts;
        public Long caller;
        public Long seller;
        public Long client_id;
    }

    public static class AvailableFilter {
        public String id;
        public String name;
        public String type;
        public List<String> values;
    }
}
