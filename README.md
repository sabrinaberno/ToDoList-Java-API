# TODO List

API para gerenciamento de tarefas (CRUD), desenvolvida como parte de um teste pessoal para aprender mais sobre Java e Spring Boot.

O projeto foi baseado [neste vídeo](https://youtu.be/IjProDV001o), com adaptações e melhorias feitas durante o processo de aprendizado.

---

## 🚀 Tecnologias Utilizadas

- [Spring Boot 3](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [MySQL](https://dev.mysql.com/downloads/)
- Hibernate ORM
- Java 21

---

## 📌 Práticas Adotadas

- Princípios SOLID, DRY, YAGNI, KISS
- API RESTful com status HTTP apropriados
- Injeção de Dependências com Spring
- Validação de dados (Bean Validation)
- Tratamento centralizado de erros
- Documentação automática com Swagger/OpenAPI
- Persistência de dados com Spring Data JPA e MySQL

---

## Como Executar

1. Clone este repositório:

```bash
git clonehttps://github.com/sabrinaberno/ToDoList-Java-API
```

2. Configure seu banco de dados MySQL com as seguintes informações no arquivo src/main/resources/application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/todolistApiJava
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
```
3. Construa o projeto:
```bash
./mvnw clean package
```
4. Execute a aplicação:
```bash 
java -jar target/to-do-list-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em:
```bash
http://localhost:8080
```
A documentação Swagger estará disponível em:
```bash
http://localhost:8080/swagger-ui/index.html
```

## API Endpoints
As requisições podem ser feitas usando ferramentas como **HTTPie**, **Postman** ou **curl**.

### Criar Tarefa

```bash
http POST :8080/todos nome="Curso API" descricao="Finalizar curso Java" prioridade:=1
```
Nota: Não envie o campo id no momento da criação.

Resposta esperada:
```bash
{
  "id": 1,
  "nome": "Curso API",
  "descricao": "Finalizar curso Java",
  "prioridade": 1,
  "realizado": false
}
```

### Listar Tarefa
```bash
http GET :8080/todos
```

### Atualizar Tarefa
```bash
http PUT :8080/todos/1 nome="Curso API Atualizado" descricao="Descrição atualizada" prioridade:=2 realizado:=true
```
### Remover Tarefa
```bash
http DELETE :8080/todos/1
```

## Observações

- O campo `realizado` é um **booleano** (`true` ou `false`) para indicar se a tarefa foi concluída.
- O campo `prioridade` aceita **números inteiros**.
- O campo `id` é gerado automaticamente e **não deve ser enviado** na criação (`POST`). O envio de um `id` pode causar erro.
