package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.TableCreateRequest;
import br.com.mercadoturbo.mercadolivre.dto.TableCreateResponse;
import br.com.mercadoturbo.mercadolivre.service.CreateTableService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/catalog/charts")
public class CreateTableResource {
    
    @Inject
    CreateTableService createTableService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TableCreateResponse> createTable(
            @HeaderParam("Authorization") String authorization,
            TableCreateRequest request) {
        return createTableService.createTable(authorization, request);
    }

    @GET
    @Path("/{chart_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TableCreateResponse> getTable(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId) {
        return createTableService.fetchTable(authorization, chartId);
    }
    @PUT
    @Path("/{chart_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TableCreateResponse> updateTable(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId,
            TableCreateRequest request) {
        return createTableService.updateTable(authorization, chartId, request);
    }
    @DELETE
    @Path("/{chart_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TableCreateResponse> deleteTable(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId) {
        return createTableService.deleteTable(authorization, chartId);
    }

    @POST
    @Path("/{chart_id}/rows")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TableCreateResponse> addRow(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId,
            TableCreateRequest.Row row) {
        return createTableService.addRow(authorization, chartId, row);
    }

    @PUT
    @Path("/{chart_id}/rows/{row_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TableCreateResponse> updateRow(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId,
            @PathParam("row_id") String rowId,
            TableCreateRequest.Row row) {
        return createTableService.updateRow(authorization, chartId, rowId, row);
    }
}
