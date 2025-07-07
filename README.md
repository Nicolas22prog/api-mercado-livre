
# API Proxy Mercado Livre

## 1. Objetivo do Projeto

Este projeto tem como finalidade fornecer uma camada intermediária (proxy) entre sistemas externos (integradores) e a API oficial do Mercado Livre.  
O objetivo é:

- Simplificar a integração com a plataforma.
- Garantir conformidade com políticas e padrões do Mercado Livre.
- Centralizar o controle de autenticação, roteamento e consistência de dados.

---

## 2. Endpoints Disponíveis

### 2.1. Dados do Usuário

- `GET /users/{user_id}` — Retorna as informações do vendedor associado ao `user_id`.
- `GET /users/me` — Retorna os dados do vendedor autenticado.

---

### 2.2. Itens do Usuário

- `GET /users/{user_id}/items/search` — Retorna a lista de itens ativos do vendedor.  
  Parâmetros opcionais: `limit`, `offset`, `user_product_id` (em desenvolvimento)

---

### 2.3. Comunicados e Notificações

- `GET /communications/notices` — Retorna comunicados enviados ao vendedor.  
  Parâmetros opcionais: `limit`, `offset`

---

### 2.4. Perguntas

- `GET /questions/search?item_id={ITEM_ID}` — Retorna perguntas feitas em um item.  
  Parâmetros opcionais: `limit`

---

### 2.5. Respostas a Perguntas

- `POST /answers` — Envia uma resposta.  
  Exemplo de body:
  ```json
  {
    "question_id": 123456789,
    "text": "Sua resposta aqui."
  }
  ```

---

### 2.6. Usuários Bloqueados

- `GET /block-api/search/users/{user_id}` — Lista de usuários bloqueados.

---

### 2.7. Pedidos

- `GET /orders/search?seller={SELLER_ID}` — Lista de pedidos.
- `GET /orders/search?seller={SELLER_ID}&q={ORDER_ID}` — Detalha pedido específico.
- `GET /orders/search?buyer={BUYER_ID}` — Pedidos do comprador.  
  Parâmetros opcionais: `limit`, `offset`

---

### 2.8. Pagamentos

- `GET /payments/{payment_id}` — Dados de pagamento.

---

### 2.9. Feedback

- `GET /orders/{ORDER_ID}/feedback`
- `POST /orders/{ORDER_ID}/feedback`

---


### 2.10. Métricas (Visitas)

- `GET /visits/users/{USER_ID}/items_visits/time_window` — Visitas aos itens de um usuário em um intervalo de tempo.
- `GET /visits/users/{USER_ID}/items_visits` — Visitas aos itens de um usuário.
- `GET /visits/items/{ITEM_ID}/contacts/questions` — Interações de perguntas por item.
- `GET /visits/users/{USER_ID}/contacts/questions` — Interações de perguntas por usuário.
- `GET /visits/users/{USER_ID}/contacts/questions/time_window` — Interações em um intervalo de tempo por usuário.
- `GET /visits/items/{ITEM_ID}/contacts/questions/time_window` — Interações em um intervalo de tempo por item.
- `GET /visits/items/visits?ids={ITEM_ID}` — Visitas para um ou mais itens.
- `GET /visits/items/visits?ids={ITEM_ID}&last={LAST}&unit={UNIT}` — Visitas recentes com granularidade de tempo.

⚠️ Observação: Os endpoints de visitas aceitam apenas **um item por requisição**.

---

### 2.11. Envios

- `GET /shipments/{SHIPMENT_ID}`
- `GET /order/{ORDER_ID}/shipments`

---

### 2.12. User Product

- `GET /user-products/{user_product_id}`
- `POST /items` — Criação de novo User Product.

---

### 2.13. Migração para User Product

- Vários endpoints para migração de itens (`/items/{item_id}/user_product_listings/validate`, `PUT /items/{item_id}/family_name`, etc.)

---

### 2.14. Estoque

- `GET /user-product/{user_product_id}/stock`
- `GET /sites/{site_id}/user-product-families/{family_id}`
- `GET /users/{user_id}/stores/search`

---

### 2.15. Preços e Custos

- `GET`, `POST`, `PUT` para preços padrões, quantidade, listagem, simulações e automação.

---

### 2.16. Imagens

- `POST /moderations/pictures/diagnostic` — Valida conformidade.
- `POST /pictures/items/upload` — Upload de imagens locais.

---

### 2.17. Atributos

- Consultas de atributos por categoria e item.
- Inclusão e validação condicional de atributos técnicos.

---

### 2.18. Catálogo

- `POST /catalog/charts/search`
- `POST /catalog/charts/domains/search`

---

### 2.19. Domínios

- `GET /domains/{domain_id}/technical_specs`
- `POST /domains/{domain_id}/technical_specs`

---

### 2.20. Medidas (Charts)

- `POST`, `GET`, `PUT`, `DELETE` — criação, edição e remoção de tabelas de medidas.

---

### 2.21. Tendências (Trends)

- `GET /trends/{site_id}`
- `GET /trends/{category_id}`

---

### 2.22. Pós-venda (Post-Purchase)

- Diversos endpoints para gerenciamento completo de reclamações (`claims`):  
  ações, status, mensagens, anexos, reembolsos parciais/totais, evidências, custos, histórico, mediações e trocas.

---

### 2.23. Descrição do Produto

- `GET /items/description/{item_id}`
- `POST /items/description/{item_id}`
- `PUT /items/description/{item_id}`

---

### 2.24. Automação de Preços

- `GET /pricing-automation/items/{item_id}/rules`
- `POST /pricing-automation/items/{item_id}/automation`

---

## 3. Observações Técnicas

- O endpoint:
  ```
  GET /sites/MLB/items/search?seller_id={SELLER_ID}&category={CATEGORY_ID}
  ```
  está **descontinuado** e retorna **HTTP 400 - Bad Request**.

  ✅ **Alternativa recomendada**:  
  Use `GET /users/{USER_ID}/items/search` e filtre por categoria no lado cliente.

---

## 4. Autenticação

Todos os endpoints que envolvem dados sensíveis ou manipulação de informações requerem o uso de um **Bearer Token** no header:

```
Authorization: Bearer {TOKEN}
```

---

## 5. Licença

Este projeto é de uso interno e segue as políticas de integração com o Mercado Livre. Consulte os termos de uso da plataforma antes de distribuir.

---
