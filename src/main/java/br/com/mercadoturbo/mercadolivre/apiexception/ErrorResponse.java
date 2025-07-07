package br.com.mercadoturbo.mercadolivre.apiexception;

import java.util.List;

public class ErrorResponse {
    private int status;
    private String message;
    private String error;
    private List<ErrorDetail> errors;

    public ErrorResponse(String error, String message, int status) {
        this.error = error;
        this.status = status;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }

    public static class ErrorDetail {
        public String code;
        public String message;
        public Cell cell;
    }

    public static class Cell {
        public String attribute_id;
        public Row row;
    }

    public static class Row {
        public String id;
        public MainAttribute main_attribute;
    }

    public static class MainAttribute {
        public String id;
        public String value;
    }
}