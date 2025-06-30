package br.com.mercadoturbo.mercadolivre.dto;

import java.util.List;


public class AlicotaRequest {
    public Long id;
    public String description;
    public Long user_id;
    public List<Transaction> transactions;

    public static class Transaction {
        public String transaction_type;
        public List<Operation> operations;
    }

    public static class Operation {
        public String operation_type;
        public String customer_type;
        public String fiscal_model_id;
        public String origin;
        public List<Rule> rules;
        public List<Message> messages;
        public List<Attribute> attributes;
    }

    public static class Rule {
        public String rule;
        public RuleValue value;
    }

    public static class RuleValue {
        // Para rule = "icms"
        public List<Destination> destinations;
        // Para rule = "icms_composition"
        public List<String> composition;
        // Para rule = "ipi", "pis", "cofins"
        public String cst;
        public String cenq;
        public Integer ppis;
        public Integer pcofins;
    }

    public static class Destination {
        public String uf;
        public String cst;
        public Integer pfcpufdest;
        public Integer picmsufdest;
        public Integer modbc;
        public Integer predbc;
        public Integer motdesicms;
        public String cbenef;
    }

    public static class Message {
        public Integer id;
    }

    public static class Attribute {
        public String attribute;
        public String product_origin_type;
        public AttributeValue value;
    }

    public static class AttributeValue {
        // Para override
        public List<Override> override;
        public String same_state;
        public String other_state;
    }

    public static class Override {
        public String cst;
        public String same_state;
        public String other_state;
    }
}
