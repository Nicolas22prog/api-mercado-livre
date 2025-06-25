package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class PictureUpdateRequest {

    public List<Picture> pictures;

    public static class Picture {
        public String source;
    }
}
