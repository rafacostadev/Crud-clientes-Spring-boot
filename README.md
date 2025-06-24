# Projeto CRUD de Clientes - Spring Boot

## 🚀 Desafio
Construir uma API REST com as operações básicas de CRUD para um recurso de clientes.

## 🎯 Funcionalidades

A API permite:

- 🔍 **Buscar clientes com paginação**
- 🔎 **Buscar cliente por ID**
- ➕ **Inserir um novo cliente**
- ✏️ **Atualizar dados de um cliente existente**
- ❌ **Deletar um cliente**

## 🏗️ Especificações Técnicas

- ✅ **Java**
- ✅ **Spring Boot**
- ✅ **Spring Data JPA**
- ✅ **Bean Validation**
- ✅ **ModelMapper**
- ✅ **Banco de dados H2**
- ✅ **Maven**

## 🗒️ Modelo de Dados

**Entidade:** `Client`

| Campo        | Tipo      | Descrição                         |
| -------------|-----------|------------------------------------|
| id           | Long      | Identificador único               |
| name         | String    | Nome do cliente (não pode ser vazio) |
| cpf          | String    | CPF do cliente                    |
| income       | Double    | Renda                             |
| birthDate    | LocalDate | Data de nascimento (não pode ser futura) |
| children     | Integer   | Quantidade de filhos              |

## 🔐 Validações

- **Nome:** Não pode ser vazio.
- **Data de Nascimento:** Não pode ser uma data futura (`@PastOrPresent`).

## ❗ Tratamento de Erros

- **400 Bad Request:** Tentativa de deletar alguma entidade que tenha relacionamento com outra (para operações DELETE).
- **404 Not Found:** ID não encontrado (para operações GET por ID, PUT e DELETE).
- **422 Unprocessable Entity:** Erros de validação, com mensagens customizadas para cada campo inválido.

## 🔗 Endpoints da API

| Método | Endpoint         | Descrição                      |
|--------|------------------|---------------------------------|
| GET    | /clients/{id}    | Buscar cliente por ID          |
| GET    | /clients         | Buscar clientes com paginação  |
| POST   | /clients         | Inserir novo cliente           |
| PUT    | /clients/{id}    | Atualizar cliente existente    |
| DELETE | /clients/{id}    | Deletar cliente                |

### 🔸 Exemplo de busca paginada:
``` console
http://localhost:8080/clients?page=0&size=6&sort=name
```

### 🔸 Exemplo de busca por ID:
``` console
http://localhost:8080/clients/1
```

### 🔸 Corpo JSON para criação ou atualização de cliente:
```json
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```

🧪 Ambiente de Testes
Banco de dados H2 configurado.

Projeto possui seed com 15 clientes usando dados fictícios.

Pode ser testado facilmente via Postman.

🛠️ Como Executar

1. Clone o projeto:
   ``` console
   git clone git@github.com:rafacostadev/Crud-clientes-Spring-boot.git
   ```
2. Abra na IDE de sua preferência e execute o projeto como Spring Boot.
3. Abra o Postman e utilize das requisições HTTP para testar.
