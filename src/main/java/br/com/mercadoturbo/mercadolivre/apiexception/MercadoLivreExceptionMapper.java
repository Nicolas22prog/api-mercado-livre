package br.com.mercadoturbo.mercadolivre.apiexception;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class MercadoLivreExceptionMapper implements ResponseExceptionMapper<ApiException>{

    @Override
    public ApiException toThrowable(Response response) {
        try{
            String json = response.readEntity(String.class);
            JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();

            String errorMessage = jsonObject.getString("error", "Erro desconhecido");
            if(errorMessage.isEmpty()){
                errorMessage = "Erro desconhecido";
            }
            String message = jsonObject.getString("message", "Erro desconhecido");
            int status = jsonObject.getInt("status", response.getStatus());

            ErrorResponse error = new ErrorResponse(errorMessage, message, status);

            if (jsonObject.containsKey("errors") && !jsonObject.isNull("errors")) {
                JsonArray errorsArray = jsonObject.getJsonArray("errors");
                List<ErrorResponse.ErrorDetail> errorDetails = new ArrayList<>();
                for (int i = 0; i < errorsArray.size(); i++) {
                    JsonObject err = errorsArray.getJsonObject(i);
                    ErrorResponse.ErrorDetail detail = new ErrorResponse.ErrorDetail();
                    detail.code = err.getString("code", null);
                    detail.message = err.getString("message", null);
                    if (err.containsKey("cell") && !err.isNull("cell")) {
                        JsonObject cellObj = err.getJsonObject("cell");
                        ErrorResponse.Cell cell = new ErrorResponse.Cell();
                        cell.attribute_id = cellObj.getString("attribute_id", null);
                        if (cellObj.containsKey("row") && !cellObj.isNull("row")) {
                            JsonObject rowObj = cellObj.getJsonObject("row");
                            ErrorResponse.Row row = new ErrorResponse.Row();
                            row.id = rowObj.isNull("id") ? null : rowObj.getString("id", null);
                            if (rowObj.containsKey("main_attribute") && !rowObj.isNull("main_attribute")) {
                                JsonObject mainAttrObj = rowObj.getJsonObject("main_attribute");
                                ErrorResponse.MainAttribute mainAttr = new ErrorResponse.MainAttribute();
                                mainAttr.id = mainAttrObj.getString("id", null);
                                mainAttr.value = mainAttrObj.getString("value", null);
                                row.main_attribute = mainAttr;
                            }
                            cell.row = row;
                        }
                        detail.cell = cell;
                    }
                    errorDetails.add(detail);
                }
                error.setErrors(errorDetails);
            }
            return new ApiException(error); 
        } catch(Exception e){
            return new ApiException(new ErrorResponse("Erro Desconhecido","Verificar token",response.getStatus()));
        }
    }
}
