# Projeto Atividade Compensatória - BRADWBK 2025/1

## Descrição

Este projeto foi desenvolvido como **atividade compensatória** individual para a disciplina de Desenvolvimento Web Back-end (BRADWBK), conforme orientações do professor. O objetivo é demonstrar domínio na implementação de uma API GraphQL em Java com Spring Boot, integrando com banco de dados relacional, a partir de uma das entidades do projeto bimestral do grupo.

> **Responsável:** Lybio Moraes Junior  
> **Entidade escolhida:** Task (Tarefa)  
> **Tema do grupo:** Gerenciador de Tarefas

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5**
- **Spring Boot Starter GraphQL**
- **Spring Boot Starter Data JPA**
- **PostgreSQL**
- **Lombok**
- **Maven**
- **Dotenv Java** (para variáveis de ambiente)

---

## Entidade Implementada: Task

A entidade `Task` representa uma tarefa do sistema, com os seguintes atributos e relacionamentos:

- **Atributos principais:**
  - `id` (Long, PK)
  - `title` (String, obrigatório)
  - `description` (String, opcional)
  - `done` (boolean, status de conclusão)
  - `createdAt` (data/hora de criação)
  - `dueDate` (data de vencimento)
- **Relacionamentos:**
  - **Muitos-para-um** com `User` (usuário dono da tarefa)
  - **Muitos-para-um** com `Category` (categoria da tarefa)
  - **Muitos-para-muitos** com `Tag` (tags associadas)
  - **Um-para-um** com `Location` (localização da tarefa)

---

## Especificação do Schema GraphQL

O schema GraphQL implementado para a entidade `Task` está em `src/main/resources/graphql/task.graphqls`:

```graphql
type Task {
  id: ID!
  title: String!
  description: String
  done: Boolean!
  category: String
  tags: [String]
  createdAt: String
  dueDate: String
  location: Location
}

type Location {
  id: ID!
  name: String!
  address: String
  latitude: Float
  longitude: Float
}

input TaskInput {
  title: String!
  description: String
  category: String
  tags: [String]
  dueDate: String
  locationId: ID
}

type Query {
  getAllTasks: [Task]
  getTaskById(id: ID!): Task
  getTasksByUserId(userId: ID!): [Task]
}

type Mutation {
  createTask(taskInput: TaskInput!): Task
  updateTask(id: ID!, taskInput: TaskInput!): Task
  deleteTask(id: ID!): Task
  toggleTaskStatus(id: ID!): Task
}
```

---

## Endpoints GraphQL Disponíveis

### Queries

| Query                | Descrição                        | Parâmetros         | Retorno         |
|----------------------|----------------------------------|--------------------|-----------------|
| `getAllTasks`        | Lista todas as tarefas           | -                  | `[Task]`        |
| `getTaskById`        | Busca tarefa por ID              | `id: ID!`          | `Task`          |
| `getTasksByUserId`   | Lista tarefas de um usuário      | `userId: ID!`      | `[Task]`        |

### Mutations

| Mutation             | Descrição                        | Parâmetros         | Retorno         |
|----------------------|----------------------------------|--------------------|-----------------|
| `createTask`         | Cria uma nova tarefa             | `taskInput`        | `Task`          |
| `updateTask`         | Atualiza uma tarefa existente    | `id`, `taskInput`  | `Task`          |
| `deleteTask`         | Remove uma tarefa                | `id`               | `Task`          |
| `toggleTaskStatus`   | Alterna status de conclusão      | `id`               | `Task`          |

---

## Como Executar o Projeto

### Pré-requisitos

- Java 17+
- Maven
- PostgreSQL

### Configuração

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repositorio>
   cd <nome-da-pasta>
   ```

2. **Configure as variáveis de ambiente** (pode usar um arquivo `.env`):

   ```
   DB_URL=jdbc:postgresql://localhost:5432/seubanco
   DB_USER=seuusuario
   DB_PASS=suasenha
   ```

3. **Ajuste o arquivo `src/main/resources/application.properties` se necessário:**

   ```properties
   spring.datasource.url=${DB_URL}
   spring.datasource.username=${DB_USER}
   spring.datasource.password=${DB_PASS}
   spring.datasource.driver-class-name=org.postgresql.Driver

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

   server.port=8080
   ```

4. **Execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Acesse o playground GraphQL:**
   - Normalmente disponível em: `http://localhost:8080/graphiql` ou `/graphql`

---

## Testes

- **Testes funcionais:** Podem ser realizados via GraphiQL, Postman, Insomnia ou Thunder Client, enviando queries e mutations conforme o schema acima.
- **Testes de integração:** O projeto possui estrutura para testes automatizados (Spring Boot Starter Test).

---

## Estrutura de Diretórios

```
src/
  main/
    java/
      com/codexasistemas/todoapp/api/
        model/         # Entidades JPA
        resolver/      # Resolvers GraphQL
        service/       # Serviços de negócio
        repository/    # Repositórios JPA
        dto/           # DTOs para entrada/saída
    resources/
      graphql/         # Schemas GraphQL
      application.properties
```

---

## Observações

- Este projeto é **individual** e implementa apenas a entidade `Task` via GraphQL, conforme solicitado na atividade compensatória.
- A integração com o banco de dados é feita via JPA/Hibernate.
- O código segue boas práticas de organização e separação de camadas (DTO, Service, Repository, Resolver).

---

## Licença

Este projeto está licenciado sob os termos da licença MIT.  
Veja o arquivo [LICENSE](./LICENSE) para mais detalhes.

---

## Autor

- **Nome:** Lybio Moraes Junior
- **Prontuário:** BP303934X
- **Disciplina:** Desenvolvimento Web Back-end (BRADWBK) - IFSP BRA
- **Data:** 2025/06 