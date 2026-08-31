# SOL System — Gestão de Loja Física

Backend REST para gestão de uma única loja familiar de roupas, com foco em operação presencial: catálogo, variações, estoque, fornecedores, entradas, vendas, caixa, clientes, crediário, funcionários, usuários/permissões, cancelamentos, auditoria, despesas, relatórios e resumo diário via Telegram.

> **Não é e-commerce no MVP.** Landing page, catálogo público e venda online são evoluções separadas.

## Estado atual

**Revisão documental:** 31/08/2026  
**Commit de código revisado:** `e9cbc4f7b304f873fbfce76b4de5765f641dd850`  
**Etapa concluída:** ETAPA 0 — Scaffold  
**Etapa atual:** **ETAPA 1.1 — validação da fundação técnica**

O backend possui estrutura ampla já criada, porém a maior parte das regras de negócio **ainda não está implementada**. Muitos services lançam `UnsupportedOperationException` com `TODO ETAPA ...`; o `GlobalExceptionHandler` converte isso em HTTP `501 Not Implemented`.

Existe somente o teste básico de carregamento do contexto (`SolSystemApplicationTests`). Há workflow de CI com `mvn test`, mas na revisão de 31/08/2026 não havia execução registrada para o commit atual. Portanto, **não considerar o scaffold validado até executar a ETAPA 1.1**.

## Stack oficial

- Java 21
- Spring Boot 4.1.0
- Spring Web
- Spring Data JPA
- Bean Validation
- Spring Security
- OAuth2 Resource Server como base de segurança
- JWT — estrutura preparada, implementação pendente na Etapa 1
- H2 — desenvolvimento inicial
- PostgreSQL — persistência definitiva
- Flyway — habilitado no profile PostgreSQL; migrations ainda pertencem à Etapa 5
- Springdoc OpenAPI 3.0.3 / Swagger UI
- Actuator
- JUnit / Mockito / Spring Security Test
- Testcontainers PostgreSQL

## URL base da API

Os controllers são mapeados em `/v1/...`, enquanto `application.yml` define:

```yaml
server:
  servlet:
    context-path: /api
```

Logo, a URL externa oficial é:

```text
/api/v1/...
```

Exemplo: controller `/v1/auth` → endpoint externo `/api/v1/auth/login`.

## Estratégia do repositório

O SOL System nasceu com **scaffold completo** para reduzir trabalho mecânico. Já existem entidades, DTOs, repositories, services, controllers e módulos transversais, mas a implementação deve acontecer **verticalmente e na ordem do roadmap oficial**.

Nunca interpretar “arquivo existente” como “feature pronta”. O status real é determinado por `CONTINUIDADE.md` e pelos testes.

## Identificação e proteção de dados

Toda entidade persistida herda de `BaseEntity`:

```text
Long id       -> chave interna do banco; não usar na API
UUID publicId -> identificador externo; usar em URLs, DTOs e integrações
@Version      -> controle otimista adicional
criadoEm / atualizadoEm -> timestamps UTC
```

Senhas nunca são armazenadas em texto puro. `Usuario` guarda `senhaHash`, e o fluxo planejado usa `PasswordEncoder`/BCrypt. Entidades JPA não devem ser retornadas diretamente pelos controllers.

Cliente é cadastro comercial e **não autentica**. Autenticação pertence a `Usuario`, vinculado a `Funcionario`. Administração é perfil de acesso, não outra entidade de pessoa.

## Cliente: padrão, VIP e lista negra

`Cliente` possui uma classificação mutável:

```text
PADRAO
LISTA_VIP
LISTA_NEGRA
```

- `LISTA_VIP`: cliente confiável, com aprovação administrativa/proprietário para crediário.
- `LISTA_NEGRA`: cliente problemático/inadimplente; bloqueia novas vendas a prazo.
- `PADRAO`: cliente comum.

Não usar subclasses JPA separadas para essas classificações.

## Fluxo obrigatório de desenvolvimento

```text
Revisar CONTINUIDADE + etapa do roadmap
        ↓
Entity / relacionamento
        ↓
DTOs
        ↓
Repository
        ↓
Service + regras + transação
        ↓
Controller + autorização
        ↓
Validações / Exceptions
        ↓
Testes unitários e integração necessários
        ↓
Teste local
        ↓
Atualizar documentação
        ↓
Commit
```

Não avançar uma etapa sem concluir e validar a anterior.

## Documentação — ordem de leitura para humanos ou IA

1. `docs/00_CONTEXTO_PARA_IA.md` — visão rápida de handoff, fontes de verdade e estado atual.
2. `CONTINUIDADE.md` — ponto exato onde o desenvolvimento está e próxima ação.
3. `docs/09_ROADMAP_ETAPAS.md` — ordem oficial; não criar roadmap alternativo.
4. `docs/04_REGRAS_NEGOCIO.md` — invariantes de negócio.
5. `docs/12_DECISOES_PENDENTES.md` — escolhas ainda não fechadas.
6. demais arquivos de `docs/` conforme o módulo em execução.

Se documentos e código parecerem divergir, **não escolher silenciosamente um lado**: conferir `CONTINUIDADE.md`, identificar se é decisão ou implementação incompleta e registrar a reconciliação antes de avançar.

## Próxima tarefa oficial

> **ETAPA 1.1 — executar `mvn test`, subir o profile `dev`, inspecionar o schema H2 e implementar construtores/factories controlados das entidades necessárias à fundação de segurança.**

Somente após validar 1.1 seguir para 1.2.