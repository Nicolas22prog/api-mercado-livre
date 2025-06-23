# Projeto: Proxy de Integração com a API do Mercado Livre

## Objetivo do Projeto

Este projeto tem como finalidade atuar como um proxy de integração entre um sistema externo (integrador) e a API oficial do Mercado Livre, expondo os principais recursos disponíveis na plataforma [Mercado Livre Developers](https://developers.mercadolibre.com/).

## Endpoints Disponíveis

### 1. Dados do Usuário

- `GET /users/{user_id}`  
  Retorna as informações do vendedor correspondente ao `user_id`.  
  **Observação:** o `user_id` deve estar associado ao mesmo usuário do token de autenticação (Bearer Token).

- `GET /users/me`  
  Retorna os dados do vendedor autenticado.  
  **Observação:** não é necessário informar o `user_id`.

### 2. Itens do Usuário

- `GET /users/{user_id}/items/search`  
  Retorna a lista de itens ativos do vendedor especificado.

Parâmetros opcionais:

- `limit`: Quantidade máxima de itens a serem retornados (padrão: 50)  
- `offset`: Posição inicial da busca (padrão: 0)  
- `user_product_id`: Suporte ao padrão User Product (em implementação)

### 3. Comunicados e Notificações

- `GET /communications/notices`  
  Retorna comunicados e notificações enviados pelo Mercado Livre ao vendedor autenticado.

Parâmetros opcionais:

- `limit`: Padrão 20  
- `offset`: Padrão 0

### 4. Perguntas em Itens Específicos

- `GET /questions/search?item_id={ITEM_ID}`  
  Retorna as perguntas realizadas em um item específico.

Parâmetro opcional:

- `limit`: Padrão 0

### 5. Respostas a Perguntas

- `POST /answers`  
  Permite o envio de uma resposta a uma pergunta feita em um dos itens do vendedor.

Exemplo de corpo da requisição:

```json
{
  "question_id": 123456789,
  "text": "Sua resposta aqui."
}
```

### 6. Usuários Bloqueados

- `GET /block-api/search/users/{user_id}`  
  Retorna a lista de usuários bloqueados pelo vendedor.

### 7. Pedidos

- `GET /orders/search?seller={SELLER_ID}`  
  Retorna os pedidos associados a um vendedor.

- `GET /orders/search?seller={SELLER_ID}&q={ORDER_ID}`  
  Retorna os detalhes de um pedido específico.

- `GET /orders/search?buyer={BUYER_ID}`  
  Retorna os pedidos de um comprador.

Parâmetros opcionais:

- `limit`: Padrão 50  
- `offset`: Padrão 0

### 8. Pagamentos

- `GET /payments/{payment_id}`  
  Retorna os dados de um pagamento específico.

### 9. Feedback

- `GET /orders/{ORDER_ID}/feedback`  
  Retorna os feedbacks associados a um pedido.

- `POST /orders/{ORDER_ID}/feedback`  
  Envia feedback sobre um pedido.

### 10. Métricas

- `GET /visits/users/{USER_ID}/items_visits/time_window?last={LAST}&unit={UNIT}`  
  Visitas aos itens de um usuário nos últimos `{LAST} {UNIT}`.  
  Máximo `last`: 149  
  Unidade: apenas `day`

- `GET /visits/users/{USER_ID}/items_visits?date_from={ISO_DATE}&date_to={ISO_DATE}`  
  Visitas aos itens de um usuário no período informado (formato ISO 8601).  
  **Atenção:** este endpoint possui instabilidades conhecidas.

- `GET /visits/items/{ITEM_ID}/contacts/questions?date_from={ISO_DATE}&date_to={ISO_DATE}`  
  Total de perguntas feitas a um item no período informado.

- `GET /visits/users/{USER_ID}/contacts/questions?date_from={ISO_DATE}&date_to={ISO_DATE}`  
  Total de perguntas recebidas em todos os itens do usuário.

- `GET /visits/users/{USER_ID}/contacts/questions/time_window?last={LAST}&unit={UNIT}`  
  Quantidade de perguntas recebidas nos últimos `{LAST} {UNIT}`.

- `GET /visits/items/{ITEM_ID}/contacts/questions/time_window?last={LAST}&unit={UNIT}`  
  Quantidade de perguntas feitas em um item específico nos últimos `{LAST} {UNIT}`.

- `GET /visits/items/visits?ids={ITEM_ID1},{ITEM_ID2},...&date_from={ISO_DATE}&date_to={ISO_DATE}`  
  **Limitação:** só permite um `item_id` por vez.  
  Exemplo de erro:

```json
{
  "status": 400,
  "message": "maximum amount of items to query is 1"
}
```

- `GET /visits/items/visits?ids={ITEM_ID1},{ITEM_ID2},...&last={LAST}&unit={UNIT}`  
  Mesmo comportamento do endpoint anterior.

### 11. Envios

- `GET /shipments/{SHIPMENT_ID}`  
  Retorna os dados de envio de um pedido.

- `GET /order/{ORDER_ID}/shipments`  
  Retorna as informações de envio de um pedido específico.

### 12. User Product

- `GET /user-products/{user_product_id}`  
  Retorna os dados de um User Product.

- `POST /items`  
  Cadastra um produto como User Product.

Exemplo de corpo da requisição:

```json
{
  "family_name": "Apple iPhone 256GB",
  "category_id": "MLM1055",
  "price": 17616,
  "currency_id": "MXN",
  "available_quantity": 6,
  "sale_terms": [
    { "id": "WARRANTY_TIME", "value_name": "3 meses" },
    { "id": "WARRANTY_TYPE", "value_name": "Garantía del vendedor" }
  ],
  "buying_mode": "buy_it_now",
  "listing_type_id": "gold_special",
  "condition": "new",
  "pictures": [],
  "attributes": [
    { "id": "BRAND", "value_name": "Apple" },
    { "id": "COLOR", "value_name": "Azul" },
    { "id": "GTIN", "value_name": "195949034862" },
    { "id": "RAM", "value_name": "6 GB" },
    { "id": "IS_DUAL_SIM", "value_name": "Sí" },
    { "id": "MODEL", "value_name": "iPhone 15" },
    { "id": "CARRIER", "value_name": "Desbloqueado" }
  ]
}
```

**Observações:**

- O campo `family_name` é obrigatório.  
- O título do produto **não deve ser enviado**. Ele será gerado automaticamente pelo Mercado Livre com base nos atributos, domínio, `family_name`, entre outros.

### 13. Migração

- `GET /items/{item_id}/user_product_listings/validate`  
  Verifica se um item pode ser migrado para User Product.

- `POST /sites/{site_id}/items/user_product_listings`  
  Solicita a migração de um item para User Product.

Exemplo de corpo da requisição:

```json
{
  "item_id": "MLM1234"
}
```

- `PUT /items/{item_id}/family_name`  
  Atualiza o nome da família de um produto.

- `GET /items/{item_id}/migration_live_listing`  
  Retorna o status da migração do item.

- `GET /items/{item_id}/user_product_listing/validate`  
  Verifica se um item é elegível para migração para User Product.

### 14. Estoque

- `GET /user-product/{user_product_id}/stock`  
  Retorna os dados de estoque de um User Product.  
  **Este endpoint ainda não foi testado.**

- `GET /sites/{site_id}/user-product-families/{family_id}`  
  Retorna os produtos de uma determinada família.

## Observação sobre a Busca por Categorias

O endpoint abaixo foi descontinuado e retorna erro 400:

```
/sites/MLB/items/search?seller_id={SELLER_ID}&category={CATEGORY_ID}
```

**Alternativa recomendada:**

```
/users/{USER_ID}/items/search
```

Este recurso permanece funcional, porém **não permite filtragem por categoria**. Caso a segmentação por categoria seja necessária, ela deve ser realizada localmente com base nos dados retornados.