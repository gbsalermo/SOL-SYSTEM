# 02 — Arquitetura

## Status

Arquitetura definida e scaffold criado. Implementações devem respeitar esta estrutura; não migrar para microserviços ou outro estilo sem necessidade real e decisão registrada.

## Estilo

Monólito modular em camadas, escolhido por simplicidade operacional e pelo escopo de uma única loja.

```text
Controller
   ↓
Service  ← regras + orquestração + transações
   ↓
Repository
   ↓
JPA
   ↓
H2 (dev) / PostgreSQL (definitivo)
```

Módulos transversais:

```text
audit
config
exception
notification
report
scheduler
security
util
```

## Pacote raiz

```text
br.com.solsystem
```

Principais pacotes já existentes:

```text
audit
config
controller
dto/request
dto/response
entity
enums
exception
notification
repository
report
scheduler
security
service
util
```

## Regra de dependência

- Controller não acessa Repository.
- Controller recebe/devolve DTO.
- Service concentra regra de negócio e transação.
- Repository persiste/consulta e pode aplicar locks quando necessário.
- Entity não é contrato HTTP.
- Telegram não calcula relatório.
- Relatório não depende do canal Telegram.

## Agregados principais

- Catálogo: `Produto -> VariacaoProduto -> Estoque`.
- Entrada: `EntradaEstoque -> ItemEntradaEstoque`.
- Venda: `Venda -> ItemVenda + Pagamento`.
- Crediário: `ContaReceber -> Parcela -> Recebimento`.
- Caixa: `Caixa -> SessaoCaixa -> MovimentoCaixa`.

## Identidade e concorrência

`BaseEntity` já contém:

- `Long id` interno;
- `UUID publicId` externo;
- `@Version` para optimistic locking;
- timestamps UTC.

Nunca usar `Long id` em URL/request/response.

Locks pessimistas podem ser usados em pontos críticos, especialmente disputa pela última unidade de estoque.

## URL da API

`application.yml` define `server.servlet.context-path: /api`. Controllers usam `/v1/...`. A composição externa é `/api/v1/...`.

## Profiles

- `dev`: H2 em memória, `ddl-auto=create-drop`, Flyway desligado.
- `postgres`: PostgreSQL, `ddl-auto=validate`, Flyway ligado.

O profile PostgreSQL está preparado, mas as migrations do domínio pertencem à Etapa 5.

## Imutabilidade histórica

Movimentos, vendas finalizadas, recebimentos e auditorias representam fatos. Uma correção deve produzir estorno/cancelamento/novo movimento, não apagar o fato anterior.