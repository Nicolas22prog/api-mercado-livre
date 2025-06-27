package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreMedidasApi;
import br.com.mercadoturbo.mercadolivre.dto.TableCreateRequest;
import br.com.mercadoturbo.mercadolivre.dto.TableCreateResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateTableService implements Serializable {
    
    @Inject
    @RestClient
    MercadoLivreMedidasApi mercadoLivreMedidasApi;

    public Uni<TableCreateResponse> createTable(String authorization, TableCreateRequest request) {
        return mercadoLivreMedidasApi.createTable(authorization, request);
    }

    public Uni<TableCreateResponse> fetchTable(String authorization, String chartId) {
        return mercadoLivreMedidasApi.getTable(authorization, chartId);
    }

    public Uni<TableCreateResponse> updateTable(String authorization, String chartId, TableCreateRequest request) {
        return mercadoLivreMedidasApi.updateTable(authorization, chartId, request);
    }
    public Uni<TableCreateResponse> deleteTable(String authorization, String chartId) {
        return mercadoLivreMedidasApi.deleteTable(authorization, chartId);
    }

    public Uni<TableCreateResponse> addRow(String authorization, String chartId, TableCreateRequest.Row row) {
        return mercadoLivreMedidasApi.addRow(authorization, chartId, row);
    }

   
    public Uni<TableCreateResponse> updateRow(String authorization, String chartId, String rowId, TableCreateRequest.Row row) {
        return mercadoLivreMedidasApi.updateRow(authorization, chartId, rowId, row);
    }
}
