/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreTaxesApi;
import br.com.mercadoturbo.mercadolivre.client.MercadoLivreUsersApi;
import br.com.mercadoturbo.mercadolivre.dto.ItemsResponse;
import br.com.mercadoturbo.mercadolivre.dto.NotasFiscaisRequest;
import br.com.mercadoturbo.mercadolivre.dto.NotasFiscaisResponse;
import br.com.mercadoturbo.mercadolivre.dto.StockLocationsResponse;
import br.com.mercadoturbo.mercadolivre.dto.UsersResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class UsersService implements Serializable{
    
    
    @Inject
    @RestClient
    private MercadoLivreUsersApi mlu;

    @Inject
    @RestClient
    MercadoLivreTaxesApi mlt;
    
    
    public Uni<UsersResponse> fetchUsers(String accessToken, String id){
        return mlu.getUsers(accessToken, id);
    }
    
    public Uni<ItemsResponse> fetchItems(String accessToken, String id, String tags,int limit, int offset, String user_product_id){
        return mlu.getItems(accessToken, id, tags,limit, offset, user_product_id);
    }
    
    public Uni<StockLocationsResponse> fetchLocations(String accessToken, String user_id, String tags, Integer limit, Integer offset){
        return mlu.getLocations(accessToken, user_id, tags, limit, offset);
    }

    public Uni<NotasFiscaisResponse> postNotasFiscais(String accessToken, String user_id, NotasFiscaisRequest request) {
        return mlu.postNotasFiscais(accessToken, user_id, request);
    }


}
