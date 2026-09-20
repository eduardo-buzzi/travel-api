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

* Cadastrar destinos de viagem;
* Listar todos os destinos cadastrados;
* Pesquisar destinos por nome;
* Pesquisar destinos por localização;
* Buscar um destino pelo ID;
* Atualizar informações de um destino;
* Registrar avaliações;
* Recalcular automaticamente a média das avaliações;
* Excluir destinos.

---

# 3. Tecnologias utilizadas

Durante o desenvolvimento foram utilizadas as seguintes tecnologias:

* Java 17
* Spring Boot
* Spring Web
* Maven
* Git
* GitHub
* Postman

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

* Destino
* NotaAvaliacao

---

# 5. Armazenamento dos dados

Os dados são armazenados temporariamente em uma `ArrayList`, sem utilização de banco de dados.

Essa abordagem foi adotada porque o desafio solicita apenas uma primeira versão funcional da API utilizando armazenamento em memória.

Como melhoria futura, o projeto poderá utilizar um banco de dados para armazenar os dados de forma permanente.

---

# 6. Endpoints

| Método | Endpoint                               | Descrição                |
| ------ | -------------------------------------- | ------------------------ |
| GET    | `/destinos`                            | Lista todos os destinos  |
| GET    | `/destinos/{id}`                       | Busca um destino pelo ID |
| GET    | `/destinos?nome=Gramado`               | Pesquisa por nome        |
| GET    | `/destinos?localizacao=Santa Catarina` | Pesquisa por localização |
| POST   | `/destinos`                            | Cadastra um novo destino |
| PUT    | `/destinos/{id}`                       | Atualiza um destino      |
| PATCH  | `/destinos/{id}/avaliacao`             | Registra uma avaliação   |
| DELETE | `/destinos/{id}`                       | Exclui um destino        |

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

* Java 17
* Visual Studio Code ou IntelliJ IDEA

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

* cadastro de destinos;
* pesquisa por nome e localização;
* busca por ID;
* atualização de informações;
* registro de avaliações;
* exclusão de destinos.

---

# 10. Estrutura

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

# Conclusão

Este projeto foi desenvolvido como parte do Desafio 1 da disciplina de Desenvolvimento de Sistemas Web.

Durante o desenvolvimento foi possível aplicar conceitos de APIs REST utilizando Java e Spring Boot, organizando o projeto em camadas e implementando as principais operações para gerenciamento de destinos turísticos.

---

# DESAFIO 2 — EVOLUÇÃO DA API REST

A segunda etapa do projeto consiste na evolução da API REST desenvolvida no Desafio 1.

Nesta etapa, a aplicação passou a utilizar persistência de dados em banco de dados PostgreSQL, Spring Data JPA e Spring Security para autenticação e autorização dos usuários.

---

# 11. Evolução do projeto

Na primeira versão do projeto, os destinos eram armazenados temporariamente em memória utilizando uma `ArrayList`.

Na segunda versão, essa abordagem foi substituída pela persistência em banco de dados PostgreSQL.

A aplicação passou a utilizar:

* PostgreSQL para armazenamento dos dados;
* Spring Data JPA para persistência;
* Hibernate para mapeamento objeto-relacional;
* Repositories para acesso aos dados;
* Spring Security para autenticação;
* Perfis `ADMIN` e `USER` para autorização.

A estrutura da aplicação passou a seguir o seguinte fluxo:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

---

# 12. Resultado esperado

A versão evoluída da API possui os seguintes recursos:

* API REST integrada ao PostgreSQL;
* Entidades JPA corretamente mapeadas;
* Repositories utilizando Spring Data JPA;
* Camada de serviço utilizando persistência em banco de dados;
* Configuração de conexão com PostgreSQL;
* Autenticação de usuários cadastrados no banco;
* Autorização por perfil de acesso;
* Endpoints protegidos conforme as permissões definidas;
* Documentação técnica para execução e configuração;
* Usuários de teste;
* Exemplos de endpoints e regras de acesso;
* Código-fonte completo versionado no GitHub.

---

# 13. Tecnologias adicionadas

Além das tecnologias utilizadas no primeiro desafio, foram adicionadas:

* Spring Data JPA;
* Hibernate;
* PostgreSQL;
* Spring Security.

---

# 14. Mapeamento das entidades JPA

A entidade `Destino` foi adaptada para utilizar JPA.

O identificador da entidade é gerado automaticamente pelo banco de dados.

A entidade possui atributos relacionados ao destino turístico, como:

* ID;
* Nome;
* Localização;
* Descrição;
* Disponibilidade de hotel;
* Atividades;
* Média das avaliações;
* Quantidade de avaliações.

Também foi criada a entidade `Usuario`, responsável pelo armazenamento dos usuários utilizados na autenticação.

Os usuários possuem:

* ID;
* Nome de usuário;
* Senha;
* Perfil de acesso.

---

# 15. Spring Data JPA

Foi criado um repository para a entidade `Destino`:

```text
DestinoRepository
```

O repository utiliza `JpaRepository`, permitindo realizar operações como:

* Buscar todos os destinos;
* Buscar destino por ID;
* Salvar destinos;
* Atualizar destinos;
* Excluir destinos;
* Pesquisar destinos por nome;
* Pesquisar destinos por localização.

Também foi criado o:

```text
UsuarioRepository
```

responsável pelo acesso aos usuários armazenados no banco de dados.

A camada Controller não acessa diretamente o banco de dados.

O fluxo utilizado é:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Banco de dados
```

---

# 16. Persistência dos destinos

A camada `DestinoService` foi adaptada para utilizar o `DestinoRepository`.

As operações realizadas pela aplicação passaram a ser persistidas no PostgreSQL.

São realizadas operações de:

* Cadastro;
* Listagem;
* Busca;
* Pesquisa;
* Atualização;
* Avaliação;
* Exclusão.

Dessa forma, os dados não são perdidos quando a aplicação é encerrada.

---

# 17. Configuração do PostgreSQL

Para executar a versão evoluída da API é necessário possuir o PostgreSQL instalado.

É necessário criar um banco de dados para o projeto.

Exemplo:

```text
travel-api
```

No arquivo:

```text
src/main/resources/application.properties
```

deve ser configurada a conexão:

```properties
spring.application.name=travel-api

spring.datasource.url=jdbc:postgresql://localhost:5432/travel-api
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA_DO_POSTGRESQL

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

### Importante

A propriedade:

```properties
spring.datasource.password=
```

deve receber a senha do usuário `postgres` configurada no PostgreSQL da máquina onde o projeto será executado.

Por exemplo:

```properties
spring.datasource.password=123
```

caso a senha configurada localmente seja `123`.

Cada computador poderá utilizar uma senha diferente.

Também é necessário verificar se o nome do banco de dados, usuário e porta correspondem à configuração local do PostgreSQL.

---

# 18. Autenticação

Foi implementado o Spring Security para realizar a autenticação dos usuários.

Os usuários utilizados pela aplicação são armazenados no banco de dados PostgreSQL.

A aplicação consulta o `UsuarioRepository` para localizar o usuário informado na autenticação.

As senhas dos usuários são armazenadas utilizando criptografia com `BCryptPasswordEncoder`.

A autenticação utilizada nos testes foi realizada através do **Basic Auth** do Postman.

---

# 19. Usuários de teste

Para facilitar os testes da aplicação, foram configurados usuários de teste.

## Usuário ADMIN

```text
Usuário: admin
Senha: admin123
Perfil: ADMIN
```

O usuário `ADMIN` possui acesso às operações administrativas da API.

## Usuário USER

```text
Usuário: usuario
Senha: usuario123
Perfil: USER
```

O usuário `USER` possui acesso às operações permitidas para usuários comuns.

Esses usuários são destinados exclusivamente aos testes da aplicação.

---

# 20. Autorização por perfil

A aplicação possui dois perfis:

```text
ADMIN
USER
```

As permissões são definidas de acordo com o tipo de operação.

| Operação              | Público | USER | ADMIN |
| --------------------- | ------: | ---: | ----: |
| Listar destinos       |     Sim |  Sim |   Sim |
| Buscar destino por ID |     Sim |  Sim |   Sim |
| Pesquisar destinos    |     Sim |  Sim |   Sim |
| Cadastrar destino     |     Não |  Não |   Sim |
| Atualizar destino     |     Não |  Não |   Sim |
| Avaliar destino       |     Não |  Sim |   Sim |
| Excluir destino       |     Não |  Não |   Sim |

---

# 21. Endpoints protegidos

Os seguintes endpoints possuem controle de acesso:

### Cadastrar destino

```http
POST /destinos
```

Permissão:

```text
ADMIN
```

### Atualizar destino

```http
PUT /destinos/{id}
```

Permissão:

```text
ADMIN
```

### Avaliar destino

```http
PATCH /destinos/{id}/avaliacao
```

Permissão:

```text
USER ou ADMIN
```

### Excluir destino

```http
DELETE /destinos/{id}
```

Permissão:

```text
ADMIN
```

Os endpoints de consulta permanecem disponíveis publicamente.

---

# 22. Exemplos de acesso com autenticação

## Acesso como ADMIN

No Postman, selecionar:

```text
Authorization
    ↓
Basic Auth
```

Informar:

```text
Username: admin
Password: admin123
```

Com esse usuário é possível realizar operações administrativas.

Por exemplo:

```http
POST /destinos
```

ou:

```http
PUT /destinos/1
```

ou:

```http
DELETE /destinos/1
```

---

## Acesso como USER

Utilizar:

```text
Username: usuario
Password: usuario123
```

O usuário comum pode realizar:

```http
GET /destinos
```

e:

```http
PATCH /destinos/1/avaliacao
```

Porém, não possui permissão para realizar operações administrativas como:

```http
POST /destinos
```

```http
PUT /destinos/1
```

```http
DELETE /destinos/1
```

---

# 23. Testes realizados

Foram realizados testes utilizando o Postman para verificar o funcionamento da API e das regras de segurança.

Foram testados:

* Cadastro de destinos;
* Listagem de destinos;
* Busca por ID;
* Pesquisa por nome;
* Pesquisa por localização;
* Atualização de destinos;
* Registro de avaliações;
* Exclusão de destinos;
* Autenticação com usuário `ADMIN`;
* Autenticação com usuário `USER`;
* Acesso sem autenticação;
* Tentativa de acesso de `USER` a operações administrativas;
* Acesso autorizado de `ADMIN` às operações administrativas.

Os testes demonstraram o funcionamento das regras de autenticação e autorização configuradas na aplicação.

---

# 24. Estrutura atual do projeto

```text
travel-api
│
├── src
│   └── main
│       ├── java
│       │   └── br
│       │       └── com
│       │           └── travelapi
│       │               │
│       │               ├── config
│       │               │   ├── DataInitializer.java
│       │               │   └── SecurityConfig.java
│       │               │
│       │               ├── controller
│       │               │   └── DestinoController.java
│       │               │
│       │               ├── model
│       │               │   ├── Destino.java
│       │               │   ├── NotaAvaliacao.java
│       │               │   └── Usuario.java
│       │               │
│       │               ├── repository
│       │               │   ├── DestinoRepository.java
│       │               │   └── UsuarioRepository.java
│       │               │
│       │               ├── service
│       │               │   └── DestinoService.java
│       │               │
│       │               └── TravelApiApplication.java
│       │
│       └── resources
│           └── application.properties
│
├── pom.xml
├── README.md
└── .gitignore
```

---

# 25. Como executar a versão evoluída

## 1. Clonar o repositório

Clone o projeto utilizando Git:

```bash
git clone URL_DO_REPOSITORIO
```

Depois entre na pasta do projeto:

```bash
cd travel-api
```

## 2. Configurar o PostgreSQL

Crie o banco:

```text
travel-api
```

Configure o usuário e senha no arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/travel-api
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA_DO_POSTGRESQL
```

## 3. Executar a aplicação

No terminal, dentro da pasta do projeto:

```powershell
.\mvnw.cmd spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

# 26. Execução e criação das tabelas

Com a aplicação conectada ao PostgreSQL, o Hibernate realiza o gerenciamento das tabelas de acordo com as entidades JPA.

A propriedade:

```properties
spring.jpa.hibernate.ddl-auto=update
```

permite que o Hibernate atualize a estrutura das tabelas de acordo com as entidades da aplicação.

Após a inicialização, os usuários de teste são inseridos no banco quando ainda não existem.

---

# 27. Git e GitHub

O projeto foi versionado utilizando Git e disponibilizado em um repositório GitHub.

O repositório contém:

* Código-fonte completo da API;
* Configurações do projeto;
* `pom.xml`;
* `README.md`;
* Configuração do PostgreSQL;
* Entidades JPA;
* Repositories;
* Services;
* Controllers;
* Configuração do Spring Security;
* Usuários de teste;
* Arquivos necessários para execução da aplicação.

O endereço do repositório deve ser compartilhado no Ambiente Virtual de Aprendizagem conforme solicitado na atividade.

---

# Conclusão

Este projeto foi desenvolvido como parte dos desafios da disciplina de Desenvolvimento de Sistemas Web.

No Desafio 1, foi desenvolvida uma API REST utilizando Java e Spring Boot, com armazenamento em memória e implementação das principais operações para gerenciamento de destinos turísticos.

No Desafio 2, a API foi evoluída para utilizar PostgreSQL como banco de dados, Spring Data JPA para persistência e Spring Security para autenticação e autorização.

Também foram implementados os perfis `ADMIN` e `USER`, permitindo controlar o acesso às diferentes operações da API.

A evolução do projeto permitiu aplicar conceitos de APIs REST, persistência de dados, mapeamento de entidades JPA, Spring Data JPA, banco de dados, autenticação, autorização, segurança e organização em camadas.

O projeto final apresenta uma API REST funcional, integrada ao PostgreSQL e com controle de acesso aos recursos conforme os perfis definidos.
