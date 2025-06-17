/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.service;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreUsersApi;
import br.com.mercadoturbo.mercadolivre.dto.ItemsResponse;

import br.com.mercadoturbo.mercadolivre.dto.UsersResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@ApplicationScoped
public class UsersService implements Serializable{
    
    private static final Logger LOG = Logger.getLogger(UsersService.class);
    
    @Inject
    @RestClient
    private MercadoLivreUsersApi mlu;
    
    
    public Uni<UsersResponse> fetchUsers(String accessToken, String id){
        return mlu.getUsers(accessToken, id);
    }
    
    public Uni<ItemsResponse> fetchItems(String accessToken, String id, int limit, int offset){
        return mlu.getItems(accessToken, id, limit, offset);
    }
}
