package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class AttributesConditionalResponse {
         public List<RequiredAttribute> required_attributes;
         
         public static class RequiredAttribute{
             public String id;
             public String name;
         }
}
