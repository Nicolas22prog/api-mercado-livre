package br.com.mercadoturbo.mercadolivre.dto;




import java.time.OffsetDateTime;
import java.util.List;

public class QuestionsResponse extends ProxyEnabledDTO{

    public Integer total;
    public Integer limit;
    public List<QuestionDTO> questions;
    public FiltersDTO filters;
    public List<AvailableFilterDTO> available_filters;
    public List<String> available_sorts;

    public static class QuestionDTO extends ProxyEnabledDTO{
        public OffsetDateTime date_created;
        public String item_id;
        public Long seller_id;
        public String status;
        public String text;
        public List<String> tags;
        public Long id;
        public Boolean deleted_from_listing;
        public Boolean hold;
        public AnswerDTO answer;
        public FromDTO from;
        

        public static class AnswerDTO {
            public String text;
            public String status;
            public OffsetDateTime date_created;
        }

        public static class FromDTO {
            public Long id;
            public Integer answered_questions;
        }
    }

    public static class FiltersDTO {
        public int limit;
        public int offset;
        public String api_version;
        public boolean is_admin;
        public List<String> sorts;
        public long caller;
        public String item;
        public long client_id;
    }

    public static class AvailableFilterDTO {
        public String id;
        public String name;
        public String type;
        public List<String> values;
    }
}
