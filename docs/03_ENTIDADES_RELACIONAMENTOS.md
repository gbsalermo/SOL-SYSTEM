# 03 — Entidades e Relacionamentos

## Regra global

Entidades persistidas herdam de `BaseEntity`. O identificador de fronteira é `publicId`; o `id` numérico é interno.

O scaffold das entidades já existe, mas constructors/factories e invariantes devem ser consolidados na etapa correspondente.

## Catálogo

```text
Categoria 1 ── N Produto 1 ── N VariacaoProduto 1 ── 1 Estoque
```

`VariacaoProduto` concentra identidade vendável: SKU, código de barras opcional, tamanho, cor, preço atual e custo atual.

Estoque pertence à variação, nunca ao Produto genérico.

## Entrada

```text
Fornecedor 1 ── N EntradaEstoque 1 ── N ItemEntradaEstoque N ── 1 VariacaoProduto
```

Receber uma entrada deve atualizar estoque, custo e histórico na mesma transação.

## Pessoas e acesso

```text
Funcionario 1 ── 0..1 Usuario
Cliente (sem login)
```

- `Funcionario`: cadastro da pessoa que trabalha na loja.
- `Usuario`: credencial e perfis de acesso.
- `Cliente`: cadastro comercial/financeiro.
- Administrador é perfil de `Usuario`.

## Venda

```text
Cliente 0..1 ── N Venda
Funcionario 1 ── N Venda
SessaoCaixa 1 ── N Venda
Venda 1 ── N ItemVenda
Venda 1 ── N Pagamento
```

Cliente pode ser nulo para venda imediata/avulsa. Se qualquer parte da venda for crediário, Cliente é obrigatório.

`ItemVenda` congela preço e custo do momento da venda.

## Crediário

```text
Cliente 1 ── N ContaReceber
Venda 1 ── 0..1 ContaReceber
ContaReceber 1 ── N Parcela
ContaReceber 1 ── N Recebimento
Parcela 0..1 ── N Recebimento
```

Saldo devedor deve ser derivado do histórico financeiro, não duplicado em `Cliente`.

## Caixa

```text
Caixa 1 ── N SessaoCaixa 1 ── N MovimentoCaixa
```

Movimentos podem referenciar Venda, Recebimento ou Despesa. Uma sessão fechada não aceita novos movimentos.

## Histórico

`MovimentoEstoque`, `MovimentoCaixa`, `CancelamentoVenda`, `Auditoria` e `NotificacaoEnvio` não devem sofrer exclusão física no fluxo normal.

## Cuidado ao alterar relacionamentos

Antes de modificar cardinalidade ou ownership JPA, conferir `04_REGRAS_NEGOCIO.md` e a etapa do roadmap. Não simplificar relacionamento histórico apenas para facilitar um CRUD.