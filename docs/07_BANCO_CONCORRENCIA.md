# 07 — Banco, Concorrência e Consistência

## Perfis

`dev`: H2 em memória para implementação rápida.

`postgres`: PostgreSQL + Flyway + `ddl-auto=validate`.

Migrar para PostgreSQL antes de fechar Venda/Caixa/Crediário.

## Constraints obrigatórias no PostgreSQL

- `public_id` unique/not null;
- SKU unique;
- código de barras unique quando informado;
- login unique;
- CPF de cliente/funcionário unique quando informado;
- uma conta a receber por venda;
- quantidades/valores não negativos por CHECK quando aplicável;
- FKs para relações financeiras/históricas.

## Concorrência crítica: última peça

Cenário:

```text
estoque = 1
caixa A tenta comprar 1
caixa B tenta comprar 1
```

Estratégia inicial:

```text
@Transactional
→ EstoqueRepository.findByVariacaoPublicIdForUpdate()
→ revalidar quantidade
→ debitar
→ gerar MovimentoEstoque
→ persistir venda
```

Resultado: uma operação confirma; outra recebe 409.

`@Version` em `BaseEntity` continua como proteção adicional contra lost update.

## Concorrência do caixa

Ao abrir sessão, revalidar dentro da transação se já existe sessão `ABERTO`. No PostgreSQL avaliar índice/constraint parcial para reforçar uma sessão aberta por caixa.

## Idempotência

Na fase de estabilização, considerar `Idempotency-Key` em comandos sensíveis a retry: finalizar venda, receber dívida e cancelar venda.

## Dinheiro

Sempre `BigDecimal`. Nunca `double`/`float` para valores monetários.
