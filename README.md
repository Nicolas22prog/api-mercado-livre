
# API Proxy Mercado Livre

## Objetivo do Projeto

Este projeto tem como finalidade disponibilizar uma camada de integração intermediária (proxy) entre sistemas externos (integradores) e a API oficial do Mercado Livre, expondo os principais recursos da plataforma **Mercado Livre Developers**. 

---

## Endpoints Disponíveis

### 1. Dados do Usuário

- `GET /users/{user_id}`  
  Retorna informações do vendedor correspondente ao `user_id`.  
  **Observação:** O `user_id` deve estar associado ao token autenticado.

- `GET /users/me`  
  Retorna dados do vendedor autenticado.  
  **Observação:** Não requer `user_id`.

---

### 2. Itens do Usuário

- `GET /users/{user_id}/items/search`  
  Retorna a lista de itens ativos do vendedor.  
  **Parâmetros opcionais:**
  - `limit`: máximo de itens (padrão: 50)
  - `offset`: posição inicial (padrão: 0)
  - `user_product_id`: ID do User Product (em implementação)

---

### 3. Comunicados e Notificações

- `GET /communications/notices`  
  Retorna comunicados do Mercado Livre.  
  **Parâmetros opcionais:**
  - `limit`: padrão 20
  - `offset`: padrão 0

---

### 4. Perguntas em Itens Específicos

- `GET /questions/search?item_id={ITEM_ID}`  
  Retorna perguntas em um item.  
  **Parâmetro opcional:** `limit`

---

### 5. Respostas a Perguntas

- `POST /answers`  
  Envia uma resposta a uma pergunta.  
  **Exemplo JSON:**
  ```json
  {
    "question_id": 123456789,
    "text": "Sua resposta aqui."
  }
  ```

---

### 6. Usuários Bloqueados

- `GET /block-api/search/users/{user_id}`  
  Lista usuários bloqueados pelo vendedor.

---

### 7. Pedidos

- `GET /orders/search?seller={SELLER_ID}`  
  Lista de pedidos do vendedor.

- `GET /orders/search?seller={SELLER_ID}&q={ORDER_ID}`  
  Detalhes de um pedido.

- `GET /orders/search?buyer={BUYER_ID}`  
  Pedidos de um comprador.

**Parâmetros opcionais:**
- `limit`: padrão 50
- `offset`: padrão 0

---

### 8. Pagamentos

- `GET /payments/{payment_id}`  
  Retorna dados de um pagamento.

---

### 9. Feedback

- `GET /orders/{ORDER_ID}/feedback`  
  Retorna feedbacks de um pedido.

- `POST /orders/{ORDER_ID}/feedback`  
  Envia feedback para um pedido.

---

### 10. Métricas

- `GET /visits/users/{USER_ID}/items_visits/time_window?last={LAST}&unit={UNIT}`  
- `GET /visits/users/{USER_ID}/items_visits?date_from={ISO_DATE}&date_to={ISO_DATE}`  
- `GET /visits/items/{ITEM_ID}/contacts/questions?date_from={ISO_DATE}&date_to={ISO_DATE}`  
- `GET /visits/users/{USER_ID}/contacts/questions?date_from={ISO_DATE}&date_to={ISO_DATE}`  
- `GET /visits/users/{USER_ID}/contacts/questions/time_window?last={LAST}&unit={UNIT}`  
- `GET /visits/items/{ITEM_ID}/contacts/questions/time_window?last={LAST}&unit={UNIT}`  
- `GET /visits/items/visits?ids={ITEM_ID}&date_from={ISO_DATE}&date_to={ISO_DATE}`  
- `GET /visits/items/visits?ids={ITEM_ID}&last={LAST}&unit={UNIT}`  

**Observação:** Aceita apenas um item por requisição.

---

### 11. Envios

- `GET /shipments/{SHIPMENT_ID}`  
  Retorna dados de envio.

- `GET /order/{ORDER_ID}/shipments`  
  Retorna envio associado ao pedido.

---

### 12. User Product

- `GET /user-products/{user_product_id}`  
  Retorna dados de um User Product.

- `POST /items`  
  Cadastra um User Product.  
  **Exemplo:**
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
    "pictures": [...],
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

---

### 13. Migração

- `GET /items/{item_id}/user_product_listings/validate`  
- `POST /sites/{site_id}/items/user_product_listings`  
- `PUT /items/{item_id}/family_name`  
- `GET /items/{item_id}/migration_live_listing`  
- `GET /items/{item_id}/user_product_listing/validate`  

---

### 14. Estoque

- `GET /user-product/{user_product_id}/stock`  
- `GET /sites/{site_id}/user-product-families/{family_id}`  

---

### 15. Preços e Custos

- `GET /items/{ITEM_ID}/sale_price`  
  **Parâmetro `context` (opcional):**
  - `channel_marketplace`
  - `buyer_loyalty_channel_mshops`
  - `channel_proximity`
  - `mp_merchants`
  - `mp_links`

- `GET /items/{ITEM_ID}/prices`  
- `POST /items/{ITEM_ID}/prices/standard`  
- `POST /items/{ITEM_ID}/prices/standard/quantity`  
- `GET /listing_prices`  
  **Parâmetros obrigatórios:**
  - `category_id`
  - `price`
  - `currency_id`  
  **Parâmetros opcionais:**
  - `listing_type_id`
  - `official_store_id`
  - `condition`
  - `site`

---

### 16. Imagens

- `POST /moderations/pictures/diagnostic`  
  Diagnóstico da imagem.  
  **Exemplo:**
  ```json
  {
    "id": "f0b6198b-a4ef-4291-82a5-41956e0af96e",
    "picture_url": "https://miurl.com/mi_imagen.jpg",
    "context": {
      "category_id": "MLA1346",
      "title": "This a item title"
    }
  }
  ```

- `POST /pictures/items/upload`  
  Upload de imagem local (jpg, jpeg, png, gif, webp).  
  **Exemplo curl:**
  ```bash
  curl --location 'http://localhost:8080/pictures/items/upload'     --header 'Content-Type: multipart/form-data'     --header 'Authorization: Bearer {TOKEN}'     --form 'file=@"/caminho/imagem.webp"'
  ```

---

## Observação: Busca por Categorias

O endpoint descontinuado:
```
/sites/MLB/items/search?seller_id={SELLER_ID}&category={CATEGORY_ID}
```

**Alternativa recomendada:**
```
/users/{USER_ID}/items/search
```
A filtragem por categoria deve ser feita localmente após a consulta.

---
