/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadoturbo.mercadolivre.service;

import java.io.Serializable;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.mercadoturbo.mercadolivre.client.MercadoLivreItemsApi;
import br.com.mercadoturbo.mercadolivre.dto.AttributesRequest;
import br.com.mercadoturbo.mercadolivre.dto.AttributesResponse;
import br.com.mercadoturbo.mercadolivre.dto.MultigetResponse;
import br.com.mercadoturbo.mercadolivre.dto.PostItemResponse;
import br.com.mercadoturbo.mercadolivre.dto.RelistRequest;
import br.com.mercadoturbo.mercadolivre.dto.VariationFullResponse;
import br.com.mercadoturbo.mercadolivre.dto.VariationRequest;
import br.com.mercadoturbo.mercadolivre.dto.VariationsUpdateRequest;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MultigetService implements Serializable{
    
    @Inject
    @RestClient
    private MercadoLivreItemsApi multiget;
    
    public Uni<List<MultigetResponse>> fetchItens(String accesToken, String ids, String attributes){
      
        return multiget.getMultigetItens(accesToken, ids, attributes);
    }

    public Uni<PostItemResponse.Variation> getVariations(String accessToken, String item_id) {
        return multiget.getVariations(accessToken, item_id);
    }

    public Uni<PostItemResponse.Variation> getVariation(String accessToken, String item_id, String variation_id) {
        return multiget.getVariation(accessToken, item_id, variation_id);
    }

    public Uni<VariationRequest> postVariation(String accessToken, String item_id, VariationRequest request) {
        return multiget.postVariation(accessToken, item_id, request);
    }

    public Uni<VariationFullResponse> updateVariations(String accessToken, String item_id, VariationsUpdateRequest request) {
        return multiget.updateVariations(accessToken, item_id, request);
    }

    public Uni<PostItemResponse> deleteVariation(String accessToken, String item_id, String variation_id) {
        return multiget.deleteVariation(accessToken, item_id, variation_id);
    }

    public Uni<PostItemResponse> relistItem(String accessToken, String item_id, RelistRequest request) {
        return multiget.relistItem(accessToken, item_id, request);
    }

    public Uni<AttributesResponse> updateItem(String accessToken, String item_id, AttributesRequest request) {
        return multiget.updateItem(accessToken, item_id, request);
    }
}
