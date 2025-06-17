package br.com.mercadoturbo.mercadolivre.apiexception;

public class ApiException extends RuntimeException {
    private final ErrorResponse error;

    public ApiException(ErrorResponse error) {
        super(error.getMessage());
        this.error = error;
    }

    public ErrorResponse getError() {
        return error;
    }
}
