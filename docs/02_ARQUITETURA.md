# 02 — Arquitetura

## Estilo

Monólito modular em camadas, escolhido por simplicidade operacional e pelo escopo de uma única loja.

```text
Controller
   ↓
Service  ← regras e transações
   ↓
Repository
   ↓
JPA/PostgreSQL
```

Módulos transversais:

```text
security
exception
audit
report
notification
scheduler
config
util
```

## Regra de dependência

- Controller não acessa Repository.
- Controller recebe/devolve DTO.
- Service concentra regra de negócio e transação.
- Repository só persiste/consulta.
- Entity não é contrato HTTP.
- Telegram não calcula relatório.
- Relatório não depende do canal Telegram.

## Agregados principais

- Catálogo: Produto -> VariacaoProduto -> Estoque.
- Entrada: EntradaEstoque -> ItemEntradaEstoque.
- Venda: Venda -> ItemVenda + Pagamento.
- Crediário: ContaReceber -> Parcela -> Recebimento.
- Caixa: Caixa -> SessaoCaixa -> MovimentoCaixa.

## Identidade

`BaseEntity` contém `Long id`, `UUID publicId`, `@Version`, timestamps. Nunca usar `Long id` em URL/request/response.

## Imutabilidade histórica

Movimentos, vendas finalizadas, recebimentos e auditorias representam fatos. Uma correção deve produzir estorno/cancelamento/novo movimento, e não apagar o fato anterior.
