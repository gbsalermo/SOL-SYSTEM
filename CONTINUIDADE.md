# SOL System — Continuidade Oficial

## Estado atual

Data de referência: 24/08/2026.

O repositório foi inicializado com o scaffold completo do backend. A estrutura existe para reduzir trabalho mecânico, mas **as regras de negócio ainda não estão implementadas**. Services importantes lançam `UnsupportedOperationException` com o número da etapa e o comportamento esperado.

## Stack oficial

```text
Java 21
Spring Boot 4.1.x
Spring Web
Spring Data JPA
Bean Validation
Spring Security
JWT
H2 (desenvolvimento inicial)
PostgreSQL (persistência definitiva)
Flyway
Springdoc / Swagger
Actuator
JUnit / Mockito
Testcontainers PostgreSQL
```

## Decisões oficiais

- Arquitetura: monólito modular simples.
- API: `/api/v1/...`.
- `Long id`: somente banco/backend.
- `UUID publicId`: API, DTOs, URLs e integrações.
- Cliente não possui usuário/senha.
- Funcionário pode possuir `Usuario` para autenticação.
- Administrador é `PerfilAcesso.ADMINISTRADOR`, não entidade separada.
- Senha é armazenada apenas em `senhaHash`; nunca em texto puro.
- Entidades JPA não são respostas HTTP.
- Estoque é por `VariacaoProduto` (cor/tamanho/SKU).
- Toda alteração de estoque gera `MovimentoEstoque`.
- Toda alteração financeira de caixa gera `MovimentoCaixa`.
- Venda finalizada não é apagada; correção ocorre por cancelamento/estorno.
- Preço e custo são congelados em `ItemVenda`.
- Dívida do cliente vem de `ContaReceber`, não de um campo `cliente.divida`.
- `LISTA_VIP` e `LISTA_NEGRA` são classificações do mesmo Cliente.
- Promoção para VIP/liberação de crediário exige aprovação administrativa do proprietário.
- Lista negra bloqueia novas vendas a prazo.
- Relatório diário será gerado internamente e Telegram será apenas um canal de entrega.
- Secrets ficam fora do Git.

## O que já existe

- `pom.xml` e dependências.
- profiles H2/PostgreSQL.
- compose PostgreSQL.
- entidades e relacionamentos.
- repositories.
- DTOs request/response.
- services com assinaturas/TODOs.
- controllers e rotas-base.
- perfis e permissões planejadas.
- configuração Spring Security fechada por padrão.
- `PasswordEncoder` BCrypt.
- filtro JWT preparado.
- tratamento global de erros.
- correlation ID.
- scheduler/Telegram preparados.
- documentação técnica.

## Próxima tarefa oficial

> **ETAPA 1.1 — validar o scaffold localmente (`mvn test` / subir aplicação) e implementar construtores/factories controlados das entidades usadas pela segurança.**

Depois:

> **ETAPA 1.2 — implementar criação segura do primeiro administrador e `UsuarioService.criar`.**

Não avançar para Produto antes de autenticação básica, hash e autorização estarem testados.

## Regra para atualizar este arquivo

Ao concluir cada subetapa:

1. marcar como concluída no roadmap;
2. registrar decisões novas;
3. anotar testes realizados;
4. indicar a próxima tarefa exata;
5. fazer commit.
