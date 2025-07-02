package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class ReturnReviewFailResponse {
    public List<Reason> reasons;

    public static class Reason {
        public String id;
        public String name;
        public String detail;
        public int position;
    }
}
