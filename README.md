# Travel API

Projeto desenvolvido para o Desafio 1 da disciplina de Desenvolvimento de Sistemas Web.

O objetivo deste projeto é desenvolver uma API REST utilizando Java e Spring Boot para gerenciar destinos turísticos de uma agência de viagens.

---

# 1. Sobre o projeto

A agência de viagens já possui um site e um sistema interno de reservas, mas deseja disponibilizar uma API para que outras aplicações possam acessar as informações dos destinos turísticos.

Nesta primeira versão, a API foi desenvolvida utilizando armazenamento em memória, sem banco de dados, conforme solicitado no desafio.

Com ela é possível cadastrar, consultar, atualizar, avaliar e excluir destinos de viagem.

---

# 2. Funcionalidades

A API possui as seguintes funcionalidades:

- Cadastrar destinos de viagem;
- Listar todos os destinos cadastrados;
- Pesquisar destinos por nome;
- Pesquisar destinos por localização;
- Buscar um destino pelo ID;
- Atualizar informações de um destino;
- Registrar avaliações;
- Recalcular automaticamente a média das avaliações;
- Excluir destinos.

---

# 3. Tecnologias utilizadas

Durante o desenvolvimento foram utilizadas as seguintes tecnologias:

- Java 17
- Spring Boot
- Spring Web
- Maven
- Git
- GitHub
- Postman

---

# 4. Arquitetura do projeto

O projeto foi organizado em camadas para facilitar a organização e manutenção do código.

```text
Controller
    ↓
Service
    ↓
Model
```

### Controller

Recebe as requisições HTTP e encaminha cada operação para a camada de serviço.

### Service

Contém toda a lógica da aplicação, como cadastro, pesquisa, atualização, exclusão e cálculo da média das avaliações.

### Model

Representa os objetos utilizados pela aplicação.

Neste projeto foram criadas as classes:

- Destino
- NotaAvaliacao

---

# 5. Armazenamento dos dados

Os dados são armazenados temporariamente em uma `ArrayList`, sem utilização de banco de dados.

Essa abordagem foi adotada porque o desafio solicita apenas uma primeira versão funcional da API utilizando armazenamento em memória.

Como melhoria futura, o projeto poderá utilizar um banco de dados para armazenar os dados de forma permanente.

---

# 6. Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | `/destinos` | Lista todos os destinos |
| GET | `/destinos/{id}` | Busca um destino pelo ID |
| GET | `/destinos?nome=Gramado` | Pesquisa por nome |
| GET | `/destinos?localizacao=Santa Catarina` | Pesquisa por localização |
| POST | `/destinos` | Cadastra um novo destino |
| PUT | `/destinos/{id}` | Atualiza um destino |
| PATCH | `/destinos/{id}/avaliacao` | Registra uma avaliação |
| DELETE | `/destinos/{id}` | Exclui um destino |

---

# 7. Exemplos de requisições

## Cadastrar destino

```http
POST /destinos
```

```json
{
  "nome": "Gramado",
  "localizacao": "Rio Grande do Sul",
  "descricao": "Cidade turística conhecida pelo clima europeu.",
  "hotelDisponivel": true,
  "atividades": "Natal Luz, Rua Coberta e Lago Negro"
}
```

## Listar destinos

```http
GET /destinos
```

## Pesquisar por nome

```http
GET /destinos?nome=Gramado
```

## Pesquisar por localização

```http
GET /destinos?localizacao=Santa Catarina
```

## Buscar por ID

```http
GET /destinos/1
```

## Atualizar destino

```http
PUT /destinos/1
```

```json
{
  "nome": "Gramado",
  "localizacao": "Rio Grande do Sul",
  "descricao": "Destino turístico do sul do Brasil.",
  "hotelDisponivel": true,
  "atividades": "Natal Luz, Rua Coberta e Lago Negro"
}
```

## Registrar avaliação

```http
PATCH /destinos/1/avaliacao
```

```json
{
  "nota": 5
}
```

As notas aceitas vão de **1 a 5**. Sempre que uma nova avaliação é registrada, a média do destino é recalculada automaticamente.

## Excluir destino

```http
DELETE /destinos/1
```

---

# 8. Como executar o projeto

## Pré-requisitos

- Java 17
- Visual Studio Code ou IntelliJ IDEA

## Executando o projeto

Abra o terminal na pasta do projeto e execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Após iniciar a aplicação, ela ficará disponível em:

```text
http://localhost:8080
```

---

# 9. Como testar

Todos os endpoints foram testados utilizando o **Postman** durante o desenvolvimento do projeto e apresentaram o funcionamento esperado.

Exemplo de requisição:

```text
GET http://localhost:8080/destinos
```

Também foram realizados testes de:

- cadastro de destinos;
- pesquisa por nome e localização;
- busca por ID;
- atualização de informações;
- registro de avaliações;
- exclusão de destinos.

---

# 10. Estrutura do projeto

```text
travel-api
│
├── src
│   └── main
│       └── java/br
│               └── com/travelapi
│                       ├── controller
│                       │   └── DestinoController.java
│                       ├── model
│                       │   ├── Destino.java
│                       │   └── NotaAvaliacao.java
│                       ├── service
│                       │   └── DestinoService.java
│                       └── TravelApiApplication.java
│
├── pom.xml
├── README.md
└── .gitignore
```

---

# Considerações finais

Este projeto foi desenvolvido como parte do Desafio 1 da disciplina de Desenvolvimento de Sistemas Web.

Durante o desenvolvimento foi possível aplicar conceitos de APIs REST utilizando Java e Spring Boot, organizando o projeto em camadas e implementando as principais operações para gerenciamento de destinos turísticos.
