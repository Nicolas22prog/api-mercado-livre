package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreFaturamentoApi;
import br.com.mercadoturbo.mercadolivre.dto.FaturamentoResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FaturamentoService implements Serializable{
    
    @Inject
    @RestClient
    MercadoLivreFaturamentoApi faturamento;


    public Uni<FaturamentoResponse> fetchFaturamentoMensal(
        String authorization,
        String group,
        String documentType,
        Integer offset,
        Integer limit
    ) {
        return faturamento.getFaturamentoMensal(authorization, group, documentType, offset, limit);
    }

    public Uni<FaturamentoResponse> fetchFaturamentoMensalByKey(
        String authorization,
        String key,
        String group,
        String documentType,
        Integer offset,
        Integer limit
    ) {
        return faturamento.getFaturamentoMensalByKey(authorization, key, group, documentType, offset, limit);
    }
}
