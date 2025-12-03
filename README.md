# Módulo 2 - Sistema de Login com Gateway

Sistema de autenticação e autorização desenvolvido em Java com Spring Boot, utilizando arquitetura de microserviços com API Gateway.

## 🚀 Tecnologias

- **Java 17** (Amazon Corretto)
- **Spring Boot 3.5.8**
- **Spring Cloud Gateway** (WebFlux)
- **Spring Data JPA**
- **MySQL 8.0**
- **JWT** (Autenticação)
- **Docker & Docker Compose**
- **Maven**

## 📐 Arquitetura

O projeto é composto por dois microserviços:

- **gateway_app**: API Gateway que roteia requisições (porta 8080)
- **login**: Serviço de autenticação e gerenciamento de usuários
- **mysql**: Banco de dados MySQL

## 📍 Endpoints

Todos os endpoints são acessados através do Gateway na porta **8080**.

### POST `http://localhost:8080/v1/registrar`
Registra um novo usuário.

**Request:**
```json
{
  "username": "string",
  "senha": "string",
  "email": "string"
}
```

**Response:**
```json
{
  "username": "string",
  "email": "string"
}
```

### POST `http://localhost:8080/v1/login`
Realiza login e retorna token JWT.

**Request:**
```json
{
  "username": "string",
  "senha": "string"
}
```

**Response:**
```json
{
  "token": "string"
}
```

### GET `http://localhost:8080/v1/rota-protegida`
Rota protegida que requer autenticação JWT.

**Headers:**
```
Authorization: Bearer <seu_token_jwt_aqui>
``` 

**Response:**
```json
"Hello, world!"
```

## 🏃 Como Rodar

### 1. Clone o repositório
```bash
git clone <url-do-repositorio>
cd modulo2
```

### 2. Build dos projetos
```bash
# Build do Gateway
cd gateway_app
./mvnw clean install
cd ..

# Build do Login
cd login
./mvnw clean install
cd ..
```

### 3. Subir a aplicação com Docker
```bash
docker compose up --build
```

A aplicação estará disponível em `http://localhost:8080`
