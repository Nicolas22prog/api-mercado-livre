package br.com.mercadoturbo.mercadolivre.client.apiexception;


public class ErrorResponse {
        
    
        private String code;
        private int status;
        private String message;

    public ErrorResponse(String code, int status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
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
}