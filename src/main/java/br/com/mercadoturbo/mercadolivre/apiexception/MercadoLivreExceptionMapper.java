
package br.com.mercadoturbo.mercadolivre.apiexception;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.StringReader;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class MercadoLivreExceptionMapper implements ResponseExceptionMapper<ApiException>{

        @Override
        public ApiException toThrowable(Response response) {
            try{
                String json = response.readEntity(String.class);
                JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
                    
                    
                    String message = jsonObject.getString("message", "Erro desconhecido");
                    int status = jsonObject.getInt("status", response.getStatus());
                        
                    ErrorResponse error = new ErrorResponse(message,status);
                    return new ApiException(error); 
            } catch(Exception e){
                 return new ApiException(new ErrorResponse("Verificar token",response.getStatus()));
            }
        }
}
