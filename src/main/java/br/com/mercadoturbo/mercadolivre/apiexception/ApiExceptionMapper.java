
package br.com.mercadoturbo.mercadolivre.apiexception;

import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<ApiException> {

    @Override
    public Response toResponse(ApiException exception) {
        ErrorResponse error = exception.getError();
        return Response.status(error.getStatus())
                       .entity(error)
                       .build();
    }
}