# Sistema de Gestão de Controle de Usuários (CRUD)

Este é um projeto prático desenvolvido durante o curso de JAVA DEVELOPER da [DIO (Digital Innovation One)](https://www.dio.me/). O objetivo principal é construir uma API RESTful para o gerenciamento de usuários, aplicando as melhores práticas de desenvolvimento com o ecossistema Spring.

O projeto está dividido em duas etapas fundamentais:
1. **Parte 1 (Concluída):** Estrutura base da API, operações de CRUD e padrões RESTful.
2. **Parte 2 (Concluída):** Implementação de controle de acesso e autenticação com Spring Security.
3. **Parte 3 (Concluída):** Implementação e configuração do Banco de Dados (em memória) usando o H2
4. **Parte 4 (Concluída):** Autenticação JWT e Segurança com BCrypt

---

## 🚀 Tecnologias Utilizadas

* **Java 21**: Versão utilizada para o desenvolvimento da lógica central da aplicação.
* **Spring Boot 3**: Framework base para acelerar o desenvolvimento da API.
* **Spring Security**: Camada robusta para controle de autenticação e autorização (RBAC).
* **Spring Web**: Mapeamento de endpoints RESTful e gerenciamento de requisições HTTP.
* **Spring Data JPA**: Abstração da camada de persistência e comunicação com o banco de dados.
* **Java-JWT (Auth0)**: Biblioteca utilizada para geração, assinatura e validação dos tokens JWT.
* **Banco de Dados H2**: Banco de dados relacional em memória, configurado para agilizar os testes e validação das regras de negócio.
* **Maven**: Gerenciador de dependências e automação do build do projeto.

## 🔒 Estrutura de Permissões (Roles)

A API conta com um controle de acesso baseado em papéis (Role-Based Access Control):

* **`ROLE_USERS`**: Permissão para acessar rotas básicas de usuários e endpoints de teste (`/teste-users`).
* **`ROLE_MANAGERS`**: Permissão total, incluindo acesso a painéis gerenciais (`/managers`) e listagem completa de dados.

---

## 🛠️ Parte 1 - API RESTful (CRUD)

A API expõe endpoints para as seguintes operações de controle de usuários:

* **Criar Usuário** (`POST /users`) - Cadastra um novo usuário no sistema.
* **Listar Usuários** (`GET /users`) - Retorna todos os usuários cadastrados.
* **Buscar por ID** (`GET /users/{id}`) - Retorna os detalhes de um usuário específico.
* **Atualizar Usuário** (`PUT /users/{id}`) - Modifica os dados de um usuário existente.
* **Deletar Usuário** (`DELETE /users/{id}`) - Remove um usuário do sistema.

---

## 🔒 Parte 2 - Segurança (Spring Security)

A segunda etapa do projeto foi implementada com sucesso, trazendo conceitos modernos do **Spring Security 6.x (Spring Boot 3.x)**:

* **Configuração Baseada em Componentes:** Substituição do antigo `WebSecurityConfigurerAdapter` pelo uso do `@Bean` de `SecurityFilterChain`.
* **Controle de Acesso Centralizado:** Configuração de permissões de rotas usando `requestMatchers` e expressões Lambda (`->`) para um código mais limpo.
* **Autenticação em Memória:** Criação de usuários simulados em memória (`InMemoryUserDetailsManager`) com diferentes níveis de acesso:
  * `user` (Role: `USERS`) - Acesso a rotas comuns.
  * `admin` (Role: `MANAGERS`) - Acesso a rotas administrativas e de gestão.
* **Mapeamento de Rotas:** Resolução de conflitos de mapeamento ambíguo (`Ambiguous mapping`) garantindo a integridade dos endpoints do CRUD.
* **Testes de API:** Utilização do **Postman** para validação de fluxos autenticados via *Basic Auth*, tratando retornos `401 Unauthorized` e `403 Forbidden`.

---

## 🗄️ Parte 3 - Configuração do Banco de Dados (Banco H2)

O banco de dados H2 está configurado para persistência automática em memória no ficheiro `src/main/resources/application.properties`:

# Ativação do Console do H2
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:gestaodb
spring.datasource.username=sa
spring.datasource.password=

---

## 🎯 Parte 4 - Autenticação JWT e Segurança com BCrypt

Nesta última etapa, foi implementada a camada de segurança da API utilizando  **JWT (JSON Web Token)**.

* **Criptografia de Senhas:** Integração do `BCryptPasswordEncoder` para encriptar as senhas dos usuários antes de salvá-las no banco de dados H2.
* **Mapeamento de Rotas:** Configuração do `SecurityFilterChain` usando `AntPathRequestMatcher` para liberar rotas de autenticação (`/auth/**`) e proteger os endpoints de negócios por Roles (`USERS`, `MANAGERS`).
* **Emissão de Tokens:** Criação do `TokenService` para gerar tokens JWT seguros após a validação correta das credenciais com `passwordEncoder.matches()`.
* **Filtro Customizado:** Implementação do `SecurityFilter` interceptando as requisições para validar o cabeçalho `Authorization: Bearer <token>`.

---

### Tabela de Permissões de Rotas:

| Método | Endpoint | Permissão Necessária | Descrição |
| :--- | :--- | :--- | :--- |
| `POST` | `/users` | Livre (`permitAll`) | Registo de novos utilizadores no banco |
| `GET` | `/users` | `USERS` ou `MANAGERS` | Listagem de utilizadores registados |
| `GET` | `/managers` | `MANAGERS` | Rota exclusiva para Administradores |
| `GET` | `/teste-users` | `USERS` ou `MANAGERS` | Rota de teste para utilizadores autenticados |
| `ANY` | `/h2-console/**` | Livre (`permitAll`) | Acesso liberado para consola do banco de dados |

## 🔧 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/brunorafaeldev/gestao-usuarios-springweb.git](https://github.com/brunorafaeldev/gestao-usuarios-springweb.git)
