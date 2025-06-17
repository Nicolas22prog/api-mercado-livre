package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreNoticesApi;
import br.com.mercadoturbo.mercadolivre.dto.NoticesResponse.Notice;
import br.com.mercadoturbo.mercadolivre.dto.NoticesResponse;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class NoticesResourceTest {

    @InjectMock
    @RestClient
    MercadoLivreNoticesApi client;

    @Test
    void testAllNoticesPagination() {
        // Página 1 (com resultados)
        NoticesResponse page1 = new NoticesResponse();
        Notice notice1 = new Notice();
        notice1.id = "001";
        notice1.title = "Aviso 1";
        page1.results = List.of(notice1);

        // Página 2 (vazia - termina paginação)
        NoticesResponse page2 = new NoticesResponse();
        page2.results = List.of();

        when(client.getNotices(anyString(), eq(20), eq(0)))
                .thenReturn(Uni.createFrom().item(page1));
        when(client.getNotices(anyString(), eq(20), eq(20)))
                .thenReturn(Uni.createFrom().item(page2));

        given()
            .header("Authorization", "Bearer FAKE_TOKEN")
        .when()
            .get("/communications/notices/all")
        .then()
            .statusCode(200)
            .body("size()", is(1))
            .body("[0].id", is("001"))
            .body("[0].title", is("Aviso 1"));
    }
}
