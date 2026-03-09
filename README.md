# 🛒 Sales System API

Uma API RESTful completa para gerenciamento de um sistema de vendas desenvolvida com Spring Boot, projetada para gerenciar usuários, pedidos, produtos, categorias e pagamentos de forma eficiente e escalável.

## 🎯 Sobre o Projeto

A Sales System API é uma aplicação backend robusta que serve como base para plataformas de e-commerce. O sistema implementa as principais operações CRUD (Create, Read, Update, Delete) com tratamento de exceções personalizado, validações de integridade referencial e uma arquitetura bem estruturada seguindo as melhores práticas do Spring Boot.

### 🔧 Principais Características

- **Arquitetura em Camadas**: Entities, Repositories, Services e Resources
- **Tratamento de Exceções**: Handler global com respostas JSON padronizadas
- **Relacionamentos Complexos**: Many-to-Many, One-to-One, One-to-Many
- **Validações**: Integridade referencial e tratamento de erros de banco
- **Dados de Teste**: População automática do banco H2

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Web**
- **H2 Database** (para desenvolvimento e testes)
- **Maven** (gerenciamento de dependências)
- **Jakarta Persistence API**
- **Jackson** (serialização JSON)

## ✨ Funcionalidades

### 🏪 Gerenciamento de Usuários
- Criar, listar, buscar, atualizar e deletar usuários
- Validação de integridade referencial (usuários com pedidos não podem ser deletados)

### 📦 Gerenciamento de Produtos
- CRUD completo de produtos
- Relacionamento Many-to-Many com categorias
- Cálculo automático de subtotais

### 🗂️ Gerenciamento de Categorias
- CRUD completo de categorias
- Relacionamento bidirecional com produtos

### 📋 Gerenciamento de Pedidos
- Criação e gerenciamento de pedidos
- Status de pedidos (WAITING_PAYMENT, PAID, SHIPPED, DELIVERED, CANCELED)
- Cálculo automático do total do pedido
- Relacionamento One-to-One com pagamentos

### 💳 Gerenciamento de Pagamentos
- Registro de pagamentos com timestamp
- Relacionamento One-to-One com pedidos
- Chave primária compartilhada

### 🛒 Itens de Pedido
- Gerenciamento de itens dentro dos pedidos
- Chave composta (Order + Product)
- Cálculo de subtotal (preço × quantidade)

## 🏗 Estrutura do Projeto

```
src/main/java/com/salessystemapi/sales_system_api/
├── entities/                 # Entidades JPA
│   ├── User.java
│   ├── Product.java
│   ├── Category.java
│   ├── Order.java
│   ├── OrderItem.java
│   ├── Payment.java
│   └── pk/
│       └── OrderItemPK.java
├── repositories/             # Interfaces Spring Data JPA
│   ├── UserRepository.java
│   ├── ProductRepository.java
│   ├── CategoryRepository.java
│   ├── OrderRepository.java
│   └── OrderItemRepository.java
├── services/                # Camada de negócio
│   ├── UserServices.java
│   ├── ProductServices.java
│   ├── CategoryServices.java
│   └── exceptions/          # Exceções personalizadas
│       ├── ResourceNotFoundException.java
│       └── DatabaseException.java
├── resources/               # Controllers REST
│   ├── UserResource.java
│   ├── ProductResource.java
│   ├── CategoryResource.java
│   └── exceptions/          # Tratamento global de exceções
│       ├── ResourceExceptionHandler.java
│       └── StandardError.java
└── config/                 # Configurações
    └── TestConfig.java      # População de dados de teste
```

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior

### Passos para Execução

1. **Clone o repositório:**
   ```bash
   git clone <repository-url>
   cd sales-system-api
   ```

2. **Compile e execute:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Acesse a aplicação:**
   - API: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:testdb`
     - Username: `sa`
     - Password: (vazio)

## 📡 Endpoints da API

### Usuários
- `GET /users` - Listar todos os usuários
- `GET /users/{id}` - Buscar usuário por ID
- `POST /users` - Criar novo usuário
- `PUT /users/{id}` - Atualizar usuário
- `DELETE /users/{id}` - Deletar usuário

### Produtos
- `GET /products` - Listar todos os produtos
- `GET /products/{id}` - Buscar produto por ID

### Categorias
- `GET /categories` - Listar todas as categorias
- `GET /categories/{id}` - Buscar categoria por ID

## 🗄 Banco de Dados

### Tabelas Principais

- **tb_user**: Usuários do sistema
- **tb_product**: Produtos disponíveis
- **tb_category**: Categorias de produtos
- **tb_order**: Pedidos realizados
- **tb_order_item**: Itens dos pedidos (chave composta)
- **tb_payment**: Pagamentos dos pedidos
- **tb_product_category**: Relacionamento Many-to-Many

### Relacionamentos

- **User ↔ Order**: One-to-Many
- **Order ↔ Payment**: One-to-One
- **Order ↔ OrderItem**: One-to-Many
- **Product ↔ OrderItem**: One-to-Many
- **Product ↔ Category**: Many-to-Many
- **OrderItem**: Chave composta (Order + Product)

## 🧪 Testes

### Dados de Teste Automáticos

A aplicação popula automaticamente o banco H2 com dados de teste:

- **2 usuários** (Alex, Alane)
- **3 categorias** (Electronics, Books, Computers)
- **5 produtos** com preços variados
- **3 pedidos** com diferentes status
- **4 itens de pedido** associados
- **1 pagamento** registrado

### Testes com Postman

1. Importe a coleção de testes (se disponível)
2. Configure a URL base: `http://localhost:8080`
3. Execute os testes na ordem: GET → POST → PUT → DELETE

## 🔄 Fluxo de Exemplo

### Criar um Pedido Completo

1. **Criar Usuário:**
   ```http
   POST /users
   {
     "name": "Alex",
     "email": "alex@gmail.com",
     "phone": "987412369"
   }
   ```

2. **Criar Categoria:**
   ```http
   POST /categories
   {
     "name": "Electronics"
   }
   ```

3. **Criar Produto:**
   ```http
   POST /products
   {
     "name": "Smart TV",
     "description": "Nulla eu imperdiet purus. Maecenas ante.",
     "price": 2190.0,
     "imgUrl": ""
   }
   ```

## 🚨 Tratamento de Erros

A API retorna respostas de erro padronizadas:

### Recurso Não Encontrado (404)
```json
{
  "timestamp": "2026-03-09T18:30:00Z",
  "status": 404,
  "error": "Resource not found",
  "message": "Resource not found. Id 999",
  "path": "/users/999"
}
```

### Violação de Integridade (400)
```json
{
  "timestamp": "2026-03-09T18:30:00Z",
  "status": 400,
  "error": "Database error",
  "message": "Integrity violation. This user cannot be deleted because it has associated orders.",
  "path": "/users/1"
}
```

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'feat: add new functionality'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request

---

**⭐ Se este projeto foi útil, deixe uma estrela!**