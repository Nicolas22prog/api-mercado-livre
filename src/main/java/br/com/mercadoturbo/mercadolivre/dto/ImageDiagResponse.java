package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class ImageDiagResponse {
 public String id;
    public List<Diagnostic> diagnostics;

    public static class Diagnostic {
        public String picture_type;
        public String action;
        public List<Detection> detections;
    }

    public static class Detection {
        public String name;
        public List<Wording> wordings;
    }

    public static class Wording {
        public String kind;
        public String value;
    }
}
