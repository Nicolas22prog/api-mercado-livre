package br.com.mercadoturbo.mercadolivre.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.mercadoturbo.mercadolivre.dto.TableCreateRequest;
import br.com.mercadoturbo.mercadolivre.dto.TableCreateResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/catalog/charts")
@RegisterRestClient(configKey = "mercado-livre-api")
public  interface  MercadoLivreMedidasApi {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<TableCreateResponse> createTable(
            @HeaderParam("Authorization") String authorization,
            TableCreateRequest request);


    @GET
    @Path("/{chart_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<TableCreateResponse> getTable(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId
            );

    @PUT
    @Path("/{chart_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<TableCreateResponse> updateTable(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId,
            TableCreateRequest request);

    @DELETE
    @Path("/{chart_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<TableCreateResponse> deleteTable(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId);

    @POST
    @Path("/{chart_id}/rows")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<TableCreateResponse> addRow(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId,
            TableCreateRequest.Row row);

    @PUT
    @Path("/{chart_id}/rows/{row_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<TableCreateResponse> updateRow(
            @HeaderParam("Authorization") String authorization,
            @PathParam("chart_id") String chartId,
            @PathParam("row_id") String rowId,
            TableCreateRequest.Row row);
}
