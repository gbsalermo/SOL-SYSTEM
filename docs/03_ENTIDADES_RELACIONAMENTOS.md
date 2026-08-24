# 03 — Entidades e Relacionamentos

## Catálogo

```text
Categoria 1 ── N Produto 1 ── N VariacaoProduto 1 ── 1 Estoque
```

`VariacaoProduto` guarda SKU, código de barras, tamanho, cor, preço atual e custo atual.

## Entrada

```text
Fornecedor 1 ── N EntradaEstoque 1 ── N ItemEntradaEstoque N ── 1 VariacaoProduto
```

Receber uma entrada atualiza estoque e custo na mesma transação.

## Pessoas e acesso

```text
Funcionario 1 ── 0..1 Usuario
Cliente (sem login)
```

Administrador é perfil de `Usuario`.

## Venda

```text
Cliente 0..1 ── N Venda
Funcionario 1 ── N Venda
SessaoCaixa 1 ── N Venda
Venda 1 ── N ItemVenda
Venda 1 ── N Pagamento
```

Cliente pode ser nulo para venda avulsa, exceto quando houver crediário.

## Crediário

```text
Cliente 1 ── N ContaReceber
Venda 1 ── 0..1 ContaReceber
ContaReceber 1 ── N Parcela
ContaReceber 1 ── N Recebimento
Parcela 0..1 ── N Recebimento
```

## Caixa

```text
Caixa 1 ── N SessaoCaixa 1 ── N MovimentoCaixa
```

Movimentos podem referenciar Venda, Recebimento ou Despesa.

## Histórico

`MovimentoEstoque`, `MovimentoCaixa`, `CancelamentoVenda`, `Auditoria` e `NotificacaoEnvio` não devem sofrer exclusão física no fluxo normal.
