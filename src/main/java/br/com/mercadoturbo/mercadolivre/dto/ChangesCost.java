package br.com.mercadoturbo.mercadolivre.dto;

import java.math.BigDecimal;

public class ChangesCost extends ProxyEnabledDTO{
    public String currency_id;
    public BigDecimal amount;
    public BigDecimal amount_usd;
}
