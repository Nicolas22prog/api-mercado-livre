package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class AttributesConditionalResponse extends ProxyEnabledDTO{
         public List<RequiredAttribute> required_attributes;
         
         public static class RequiredAttribute{
             public String id;
             public String name;
         }
}
