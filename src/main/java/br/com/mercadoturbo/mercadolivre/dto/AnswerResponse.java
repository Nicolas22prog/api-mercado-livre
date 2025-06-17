package br.com.mercadoturbo.mercadolivre.dto;


import java.time.OffsetDateTime;

public class AnswerResponse extends ProxyEnabledDTO{
    public Long id;
    public Answer answer;
    public OffsetDateTime date_created;
    public Boolean deleted_from_listing;
    public Boolean hold;
    public String item_id;
    public Long seller_id;
    public String status;
    public String text;
    public From from;

    public static class Answer {
        public OffsetDateTime date_created;
        public String status;
        public String text;
    }

    public static class From {
        public Long id;
        public Integer answered_questions;
    }
}
