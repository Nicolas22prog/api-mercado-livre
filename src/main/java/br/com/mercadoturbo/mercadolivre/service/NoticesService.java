package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreNoticesApi;
import br.com.mercadoturbo.mercadolivre.client.ReactivePagination;
import br.com.mercadoturbo.mercadolivre.dto.NoticesResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@ApplicationScoped
public class NoticesService implements Serializable{

    private static final Logger LOG = Logger.getLogger(NoticesService.class);

    @Inject
    @RestClient
    MercadoLivreNoticesApi mercadoLivreApi;

    public Uni<NoticesResponse> fetchNotices(String accessToken, Integer limit, Integer offset) {
        return mercadoLivreApi.getNotices(accessToken, limit, offset)
                .onItem().invoke(resp -> {
                    int count = (resp.results != null) ? resp.results.size() : 0;
                    LOG.infof("Página recebida (offset=%d, limit=%d) - %d resultados", offset, limit, count);
                });
    }

    public Uni<List<NoticesResponse.Notice>> fetchAllNotices(String accessToken) {
        return ReactivePagination.paginate(
                0,
                20,
                (offset, limit) -> mercadoLivreApi.getNotices(accessToken, limit, offset),
                page -> page.results,
                page -> page.results == null || page.results.isEmpty()
        );
    }
}
