package br.com.mercadoturbo.mercadolivre.apiexception;


public class ErrorResponse {
        
    
       
        private int status;
        private String message;

    public ErrorResponse( String message, int status) {
        
        this.status = status;
        this.message = message;
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