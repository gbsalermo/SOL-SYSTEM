# 12 — Decisões Pendentes

## Regra

Aqui ficam somente escolhas de negócio ainda não confirmadas. Elas não bloqueiam o scaffold, mas devem ser resolvidas **antes da etapa indicada**.

Quando uma decisão for tomada:

1. registrar a regra no documento temático adequado;
2. remover da seção pendente;
3. anotar a decisão em `CONTINUIDADE.md` se afetar a próxima implementação.

## Antes da Etapa 4

### Custo do estoque

Proposta atual: **custo médio ponderado**. Confirmar se a operação prefere último custo de compra.

## Antes da Etapa 6

### Lista negra — autoridade

`ADMINISTRADOR` pode aplicar/remover. Confirmar se `GERENTE` também poderá fazer isso ou se será exclusivo do proprietário/administração.

## Antes da Etapa 7

### Desconto por perfil

Definir limite de desconto por perfil ou se gerente/admin precisa autorizar acima de determinado percentual.

## Antes da Etapa 8

### Quantidade de caixas físicos

Confirmar se existe somente um terminal/caixa na loja ou se vale manter uso real de múltiplos caixas. O modelo já suporta vários; a decisão afeta experiência e testes, não exige refazer o núcleo.

## Antes da Etapa 9

### Forma do crediário

Confirmar se a loja trabalha com:

- vencimento único por nota;
- parcelas mensais;
- ambos.

A estrutura suporta ambos.

### Juros e multa

Não previstos no MVP. Adicionar apenas se usados de fato pela loja.

## Antes da Etapa 10

### Cancelamento de venda parcialmente paga

Definir política real para devolver dinheiro, gerar crédito ou compensar saldo já recebido. Não implementar um comportamento implícito.

## Antes da Etapa 14

### Horário do relatório diário

Configuração inicial: 19:00 em `America/Bahia`. Confirmar se esse é o horário operacional desejado.

## Decisões já resolvidas — não reabrir sem motivo novo

- VIP/liberação ou aumento de crédito: exige `ADMINISTRADOR`/proprietário.
- Lista negra: bloqueia novas vendas em crediário.
- Venda sem Cliente: permitida quando o pagamento é imediato; crediário exige Cliente.
- Cliente não possui login.
- Administrador é perfil de `Usuario`, não entidade separada.
- Telegram é canal de entrega, não motor de cálculo do relatório.