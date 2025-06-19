/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsApi;

import br.com.mercadoturbo.mercadolivre.dto.MultigetResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MultigetService implements Serializable{
    
    @Inject
    @RestClient
    private MercadoLivreItemsApi multiget;
    
    public Uni<List<MultigetResponse>> fetchItens(String accesToken, String ids, String attributes){
      
        return multiget.getMultigetItens(accesToken, ids, attributes);
    }
}
