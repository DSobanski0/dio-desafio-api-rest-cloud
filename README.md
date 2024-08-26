# dio-desafio-api-rest-cloud

Desafio da Digital Innovation One - publicando uma API REST na nuvem usando Spring Boot 3, Java 17 e Railway

## Principais Tecnologias
- **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
- **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
- **Railway**: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
  class Player {
    -String name
    -GamesOnLibrary[] gamesOnLibrary
    -GamesOnStore[] gamesOnStore
    -Plan plan
    -News[] news
  }

  class GamesOnLibrary {
    -String name
    -Number playedTime
  }

  class GamesOnStore {
    -String name
    -Number price
  }

  class Plan {
    -String name
  }

  class News {
    -String description
  }

  Player "1" *-- "N" GamesOnLibrary
  Player "1" *-- "N" GamesOnStore
  Player "1" *-- "1" Plan
  Player "1" *-- "N" News
```