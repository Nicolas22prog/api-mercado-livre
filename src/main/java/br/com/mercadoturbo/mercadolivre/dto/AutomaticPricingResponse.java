package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class AutomaticPricingResponse extends ProxyEnabledDTO{
        public String item_id;
        public List<Rule> rules;

        public static class Rule {
            public String rule_id;
        }
}
