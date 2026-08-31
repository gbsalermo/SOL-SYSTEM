# 07 — Banco, Concorrência e Consistência

## Estado atual

- profile `dev`: H2 em memória, modo PostgreSQL, `ddl-auto=create-drop`, Flyway desligado;
- profile `postgres`: PostgreSQL, `ddl-auto=validate`, Flyway ligado;
- `compose.yaml` prepara PostgreSQL local;
- migrations do domínio ainda não estão implementadas e pertencem à Etapa 5.

Não considerar o profile PostgreSQL pronto para o domínio antes das migrations.

## Momento da migração

PostgreSQL/Flyway é a ETAPA 5. Ele deve estar consolidado antes de fechar os módulos financeiros mais críticos de Venda/Caixa/Crediário.

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

Resultado esperado: uma operação confirma; outra recebe `409 Conflict`.

`@Version` em `BaseEntity` continua como proteção adicional contra lost update.

## Concorrência do caixa

Ao abrir sessão, revalidar dentro da transação se já existe sessão aberta. No PostgreSQL avaliar constraint/índice parcial para reforçar uma sessão aberta por caixa.

## Idempotência

Na fase de estabilização, considerar `Idempotency-Key` em comandos sensíveis a retry: finalizar venda, receber dívida e cancelar venda. Não antecipar essa complexidade antes do fluxo base estar correto.

## Dinheiro

Sempre `BigDecimal`. Nunca `double`/`float` para valores monetários.

## Regra de teste

Concorrência só é considerada validada quando houver teste reproduzível; teste unitário isolado não substitui teste de persistência/transação.