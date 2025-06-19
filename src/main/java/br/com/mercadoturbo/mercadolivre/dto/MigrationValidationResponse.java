package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;

public class MigrationValidationResponse extends ProxyEnabledDTO {

    public boolean is_valid;
    public List<Cause> cause;

    public static class Cause {
        public int code;
        public String message;
        public String reference;
    }
}
