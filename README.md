# Mercado Livre Notifications - Quarkus MicroProfile

Aplicação de exemplo para consumir as notificações recebidas por vendedores no Mercado Livre usando Java 21, Quarkus e MicroProfile, pronta para rodar em Docker.

## Pré-requisitos

- Java 21
- Maven 3.9+
- Docker (opcional, para rodar em container)

## Compilação

```sh
./mvnw clean package -DskipTests
```
Ou, se preferir, use o Maven do seu sistema:
```sh
mvn clean package -DskipTests
```

## Execução Local

```sh
java -jar target/mercado-livre-notifications-1.0.0-SNAPSHOT-runner.jar
```

## Execução com Docker

```sh
docker build -t meli-notifications .
docker run -it --rm -p 8080:8080 meli-notifications
```

## Exemplo de chamada

```sh
curl 'http://localhost:8080/notifications?access_token=SEU_TOKEN'
```

## Customização

- Modifique o endpoint, parse do JSON ou tratamento de dados conforme necessidade.
- Altere o token de acesso para um token válido do Mercado Livre.

---
Documentação da API: https://developers.mercadolivre.com.br/pt_br/conheca-as-novidades-que-os-vendedores-recebem
