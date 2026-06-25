# Sistema de Gestão de Controle de Usuários (CRUD)

Este é um projeto prático desenvolvido durante o curso de JAVA DEVELOPER da [DIO (Digital Innovation One)](https://www.dio.me/). O objetivo principal é construir uma API RESTful para o gerenciamento de usuários, aplicando as melhores práticas de desenvolvimento com o ecossistema Spring.

O projeto está dividido em duas etapas fundamentais:
1. **Parte 1 (Concluída):** Estrutura base da API, operações de CRUD e padrões RESTful.
2. **Parte 2 (Em Desenvolvimento):** Implementação de controle de acesso e autenticação com Spring Security.

---

## 🚀 Tecnologias Utilizadas

* **Java 21** 
* **Spring Boot** 
* **Spring Web** 
* **Persistência:** Dados armazenados em memória (Simulação com Listas) para validação das regras de negócio.
* **Maven** 
---

## 🛠️ Parte 1 - API RESTful (CRUD)

A API expõe endpoints para as seguintes operações de controle de usuários:

* **Criar Usuário** (`POST /users`) - Cadastra um novo usuário no sistema.
* **Listar Usuários** (`GET /users`) - Retorna todos os usuários cadastrados.
* **Buscar por ID** (`GET /users/{id}`) - Retorna os detalhes de um usuário específico.
* **Atualizar Usuário** (`PUT /users/{id}`) - Modifica os dados de um usuário existente.
* **Deletar Usuário** (`DELETE /users/{id}`) - Remove um usuário do sistema.

---

## 🔒 Parte 2 - Segurança Concluída (Spring Security)

A segunda etapa do projeto foi implementada com sucesso, trazendo conceitos modernos do **Spring Security 6.x (Spring Boot 3.x)**:

* **Configuração Baseada em Componentes:** Substituição do antigo `WebSecurityConfigurerAdapter` pelo uso do `@Bean` de `SecurityFilterChain`.
* **Controle de Acesso Centralizado:** Configuração de permissões de rotas usando `requestMatchers` e expressões Lambda (`->`) para um código mais limpo.
* **Autenticação em Memória:** Criação de usuários simulados em memória (`InMemoryUserDetailsManager`) com diferentes níveis de acesso:
  * `user` (Role: `USERS`) - Acesso a rotas comuns.
  * `admin` (Role: `MANAGERS`) - Acesso a rotas administrativas e de gestão.
* **Mapeamento de Rotas:** Resolução de conflitos de mapeamento ambíguo (`Ambiguous mapping`) garantindo a integridade dos endpoints do CRUD.
* **Testes de API:** Utilização do **Postman** para validação de fluxos autenticados via *Basic Auth*, tratando retornos `401 Unauthorized` e `403 Forbidden`.

---

## 🗄️ Parte 3 - Configuração do Banco de Dados Concluída  (Banco H2)

O banco de dados H2 está configurado para persistência automática em memória no ficheiro `src/main/resources/application.properties`:

# Ativação do Console do H2
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:gestaodb
spring.datasource.username=sa
spring.datasource.password=

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
