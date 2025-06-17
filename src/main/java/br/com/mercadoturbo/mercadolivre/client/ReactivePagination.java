package br.com.mercadoturbo.mercadolivre.client;

/**
 *
 * @author Danilo G. Magrini
 */
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class ReactivePagination {

    /**
     * Paginação reativa genérica.
     *
     * @param initialOffset Ponto inicial da paginação (geralmente 0)
     * @param limit Quantidade por página
     * @param pageFetcher Função que recebe (offset, limit) e retorna Uni<Page>
     * @param pageExtractor Função que extrai List<T> de uma página
     * @param stopWhen Condição para parar (ex: página vazia)
     * @param <Page> Tipo da página completa
     * @param <T> Tipo do item individual
     * @return Uni<List<T>> Todos os itens de todas as páginas
     */
    public static <Page, T> Uni<List<T>> paginate(
            int initialOffset,
            int limit,
            BiFunction<Integer, Integer, Uni<Page>> pageFetcher,
            java.util.function.Function<Page, List<T>> pageExtractor,
            Predicate<Page> stopWhen
    ) {
        final int[] offset = {initialOffset};

        return Multi.createBy().repeating()
                .uni(() -> pageFetcher.apply(offset[0], limit)
                .onItem().invoke(page -> offset[0] += limit))
                .until(stopWhen)
                .onItem().transform(pageExtractor) // extrai List<T> da página
                .flatMap(list -> Multi.createFrom().iterable(list)) // achata
                .collect().asList();
    }
}
