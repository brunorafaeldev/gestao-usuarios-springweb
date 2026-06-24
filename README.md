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

## 🛠️ Funcionalidades (Parte 1 - RESTful CRUD)

A API expõe endpoints para as seguintes operações de controle de usuários:

* **Criar Usuário** (`POST /users`) - Cadastra um novo usuário no sistema.
* **Listar Usuários** (`GET /users`) - Retorna todos os usuários cadastrados.
* **Buscar por ID** (`GET /users/{id}`) - Retorna os detalhes de um usuário específico.
* **Atualizar Usuário** (`PUT /users/{id}`) - Modifica os dados de um usuário existente.
* **Deletar Usuário** (`DELETE /users/{id}`) - Remove um usuário do sistema.

---

## 🔒 Próximos Passos (Parte 2)

A segunda etapa do projeto consistirá na implementação do **Spring Security**, onde serão adicionados:
* Autenticação e Autorização de usuários.
* Proteção dos endpoints do CRUD de acordo com o nível de permissão (Roles).

---

## 🔧 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/brunorafaeldev/gestao-usuarios-springweb.git](https://github.com/brunorafaeldev/gestao-usuarios-springweb.git)
