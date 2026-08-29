# Projeto desenvolvido para o Desafio 1 da disciplina de Desenvolvimento de Sistemas Web.

A proposta do trabalho é desenvolver uma API REST para uma agência de viagens, permitindo o gerenciamento de destinos turísticos.

## 1. Visão geral do problema

A agência de viagens já possui um site e um sistema interno de reservas, mas pretende ampliar seus serviços digitais e permitir que outros sistemas possam utilizar informações sobre seus destinos turísticos.

Por isso, foi desenvolvida uma API REST que permite cadastrar, consultar, atualizar, avaliar e excluir destinos de viagem.

Nesta primeira versão, os dados são armazenados em memória, sem utilização de banco de dados.

## 2. Funcionalidades

A API permite:

- Cadastrar destinos de viagem;
- Listar todos os destinos;
- Pesquisar destinos por nome;
- Pesquisar destinos por localização;
- Visualizar os detalhes de um destino;
- Atualizar informações de um destino;
- Registrar avaliações;
- Recalcular a média das avaliações;
- Excluir destinos.

## 3. Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Maven
- Git
- GitHub
- Postman

## 4. Arquitetura

Foi utilizada uma arquitetura dividida em camadas:

```text
Controller
    ↓
Service
    ↓
Model
```

Essa divisão foi utilizada para deixar o projeto mais organizado e facilitar futuras alterações.

### Controller

A camada Controller recebe as requisições HTTP e retorna as respostas da API.

No projeto, ela é responsável pelos endpoints relacionados aos destinos.

### Service

A camada Service possui a lógica principal da aplicação.

É nela que são realizadas operações como:

- cadastro;
- pesquisa;
- atualização;
- avaliação;
- exclusão.

A lógica foi separada do Controller para facilitar a organização e manutenção do código.

### Model

A camada Model representa os dados utilizados pela aplicação.

As principais classes são:

- `Destino`
- `NotaAvaliacao`

## 5. Armazenamento dos dados

Nesta primeira versão não foi utilizado banco de dados.

Os destinos são armazenados temporariamente em uma lista (`ArrayList`) dentro da aplicação.

Essa escolha atende ao objetivo do desafio, que permite o armazenamento temporário em memória.

Em uma futura versão, o projeto poderá utilizar um banco de dados para manter os dados armazenados mesmo depois que a aplicação for encerrada.

## 6. Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/destinos` | Lista todos os destinos |
| GET | `/destinos/{id}` | Busca um destino pelo ID |
| GET | `/destinos?nome=Gramado` | Pesquisa por nome |
| GET | `/destinos?localizacao=Santa Catarina` | Pesquisa por localização |
| POST | `/destinos` | Cadastra um novo destino |
| PUT | `/destinos/{id}` | Atualiza um destino |
| PATCH | `/destinos/{id}/avaliacao` | Adiciona uma avaliação |
| DELETE | `/destinos/{id}` | Exclui um destino |

## 7. Exemplos de requisições

### 7.1 Cadastrar destino

```http
POST /destinos
```

JSON:

```json
{
    "nome": "Gramado",
    "localizacao": "Rio Grande do Sul",
    "descricao": "Cidade turística conhecida pelo clima europeu.",
    "hotelDisponivel": true,
    "atividades": "Natal Luz, Rua Coberta e Lago Negro"
}
```

### 7.2 Listar destinos

```http
GET /destinos
```

### 7.3 Pesquisar por nome

```http
GET /destinos?nome=Gramado
```

### 7.4 Pesquisar por localização

```http
GET /destinos?localizacao=Santa Catarina
```

### 7.5 Buscar por ID

```http
GET /destinos/1
```

### 7.6 Atualizar destino

```http
PUT /destinos/1
```

JSON:

```json
{
    "nome": "Gramado",
    "localizacao": "Rio Grande do Sul",
    "descricao": "Destino turístico do sul do Brasil.",
    "hotelDisponivel": true,
    "atividades": "Natal Luz, Rua Coberta e Lago Negro"
}
```

### 7.7 Registrar avaliação

```http
PATCH /destinos/1/avaliacao
```

JSON:

```json
{
    "nota": 5
}
```

A cada nova avaliação, a quantidade de avaliações é atualizada e a média do destino é recalculada.

As notas permitidas estão entre 1 e 5.

### 7.8 Excluir destino

```http
DELETE /destinos/1
```

## 8. Respostas da API

A API utiliza códigos HTTP de acordo com o resultado da operação.

- `200 OK` - requisição realizada com sucesso;
- `201 Created` - destino criado com sucesso;
- `204 No Content` - destino excluído com sucesso;
- `400 Bad Request` - dados inválidos;
- `404 Not Found` - destino não encontrado.

## 9. Como executar o projeto

### Pré-requisitos

- Java 17;
- Visual Studio Code ou IntelliJ IDEA.

### Execução pelo terminal

Abra o terminal na pasta do projeto e execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Depois que a aplicação iniciar, ela estará disponível em:

```text
http://localhost:8080
```

## 10. Como testar

Os endpoints podem ser testados utilizando o Postman.

Exemplo:

```text
GET http://localhost:8080/destinos
```

Também podem ser testadas as operações de cadastro, pesquisa, atualização, avaliação e exclusão.

## 11. Estrutura do projeto

```text
travel-api
│
├── src
│   └── main
│       └── java\br
│               └── com \ travelapi
│                       │
│                       ├── controller
│                       │   └── DestinoController.java
│                       │
│                       ├── model
│                       │   ├── Destino.java
│                       │   └── NotaAvaliacao.java
│                       │
│                       ├── service
│                       │   └── DestinoService.java
│                       │
│                       └── TravelApiApplication.java
│
├── pom.xml
├── README.md
└── .gitignore
```

## Projeto desenvolvido para o Desafio 1 - Desenvolvimento de Sistemas Web. 