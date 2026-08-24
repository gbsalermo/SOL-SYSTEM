# SOL System — Gestão de Loja Física

Backend REST para gestão de uma loja familiar de roupas, com foco em operação presencial: produtos e variações, estoque, entradas, vendas, caixa, clientes, crediário, funcionários, usuários/permissões, cancelamentos, auditoria, relatórios e envio diário por Telegram.

> O projeto **não é um e-commerce** no MVP. Landing page e venda online são evoluções separadas.

## Stack base

- Java 21 (LTS)
- Spring Boot 4.1.x
- Spring Web
- Spring Data JPA
- Bean Validation
- Spring Security
- JWT (estrutura preparada)
- H2 para desenvolvimento rápido
- PostgreSQL para persistência definitiva
- Flyway para migrations
- Springdoc OpenAPI / Swagger
- Actuator
- JUnit / Mockito / Spring Security Test
- Testcontainers PostgreSQL

## Estratégia deste repositório

Diferente de um projeto criado totalmente do zero, o SOL System nasce com a **estrutura completa do backend já preparada**. As entidades, DTOs, repositories, services, controllers e módulos transversais existem desde o início, mas as regras de negócio dos services ficam marcadas com `TODO` e referências de etapa.

A intenção é que o desenvolvimento seja feito verticalmente, módulo por módulo, sem gastar tempo criando arquivos e decidindo nomes durante a implementação.

## Identificação e proteção de dados

Toda entidade persistida herda dois identificadores:

```text
Long id       -> chave interna do banco; nunca usada pela API
UUID publicId -> identificador externo; usado em URLs, DTOs e integrações
```

Senhas **nunca** são armazenadas em texto puro. `Usuario` guarda apenas `senhaHash`, gerado com `PasswordEncoder` (BCrypt no plano inicial). Entidades JPA não devem ser retornadas diretamente pelos controllers.

Cliente não autentica no sistema: ele é um cadastro comercial. A autenticação pertence a `Usuario`, normalmente vinculado a um `Funcionario`. Administração é um **perfil de acesso**, não outra tabela de pessoa.

## Cliente: padrão, VIP e lista negra

`Cliente` possui a classificação:

```text
PADRAO
LISTA_VIP
LISTA_NEGRA
```

- `LISTA_VIP`: cliente confiável, bom histórico e crediário aprovado pelo proprietário/administração.
- `LISTA_NEGRA`: cliente com histórico problemático/atrasos recorrentes; crediário bloqueado.
- `PADRAO`: cliente comum, sem privilégios automáticos.

A classificação é um estado do cliente e pode mudar ao longo do tempo; por isso não são usadas subclasses JPA separadas.

## Estrutura planejada

```text
br.com.solsystem
├── audit
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── enums
├── exception
├── notification
├── repository
├── report
├── scheduler
├── security
├── service
└── util
```

## Regra de desenvolvimento

Cada etapa deve ser implementada verticalmente:

```text
Entity / relacionamento
       ↓
DTOs
       ↓
Repository
       ↓
Service + regras
       ↓
Controller
       ↓
Validações / Exceptions
       ↓
Testes
       ↓
Teste local
       ↓
Atualizar CONTINUIDADE.md
       ↓
Commit
```

## Documentação

A pasta `docs/` contém visão, arquitetura, domínio, segurança, contratos, regras, relatórios, roadmap, concorrência e checklists.

Os documentos de referência principal são:

1. `CONTINUIDADE.md` — estado atual e próxima tarefa.
2. `docs/04_REGRAS_NEGOCIO.md` — comportamento obrigatório do sistema.
3. `docs/09_ROADMAP_ETAPAS.md` — ordem oficial de implementação.
4. `docs/10_GUIA_IMPLEMENTACAO.md` — como executar cada etapa.

## Primeira tarefa após o scaffold

Começar pela **ETAPA 1 — Fundação técnica e segurança mínima**, validar o projeto localmente e só então seguir para Produto/Categoria/Variações.
