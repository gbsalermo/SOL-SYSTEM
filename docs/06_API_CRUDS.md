# 06 — API, CRUDs e Operações

Base: `/api/v1`.

## Auth

- `POST /auth/login`

## Usuários

- `POST /usuarios`
- `GET /usuarios`
- `GET /usuarios/{publicId}`
- `PUT /usuarios/{publicId}`
- `PATCH /usuarios/{publicId}/desativar`

## Catálogo

- `/categorias`
- `/produtos`
- `POST /produtos/{publicId}/variacoes`
- `GET /produtos/variacoes/{publicId}`
- `GET /produtos/codigo-barras/{codigo}`

## Estoque

- `GET /estoque`
- `GET /estoque/variacao/{publicId}`
- `POST /estoque/ajustes`

## Fornecedores e entradas

- CRUD lógico `/fornecedores`
- `POST /entradas-estoque`
- `GET /entradas-estoque`
- `GET /entradas-estoque/{publicId}`

## Clientes

- CRUD lógico `/clientes`
- `PATCH /clientes/{publicId}/classificacao`

## Funcionários

- CRUD lógico `/funcionarios`

## Vendas

- `POST /vendas`
- `GET /vendas`
- `GET /vendas/{publicId}`
- `POST /vendas/{publicId}/cancelamento`

## Caixa

- `POST /caixas`
- `POST /caixas/{caixaPublicId}/abrir`
- `POST /caixas/sessoes/{sessaoPublicId}/fechar`
- `POST /caixas/sessoes/{sessaoPublicId}/sangrias`
- `POST /caixas/sessoes/{sessaoPublicId}/suprimentos`
- `GET /caixas/sessoes`

## Crediário

- `GET /crediario/contas`
- `GET /crediario/contas/vencidas`
- `GET /crediario/clientes/{publicId}/contas`
- `POST /crediario/contas/{publicId}/recebimentos`

## Despesas

- `POST /despesas`
- `GET /despesas`
- `POST /despesas/{publicId}/cancelamento`

## Relatórios

- `GET /relatorios/diario?data=YYYY-MM-DD`
- `POST /relatorios/diario/enviar-telegram?data=YYYY-MM-DD`

## Auditoria

- `GET /auditoria?entidade=VENDA&publicIdEntidade=<uuid>`

## Convenções HTTP

- 200 leitura/alteração;
- 201 criação;
- 204 comando sem body;
- 400 contrato inválido;
- 401 não autenticado;
- 403 sem permissão;
- 404 publicId inexistente;
- 409 concorrência/conflito/estoque;
- 422 regra de negócio;
- 501 somente enquanto método do scaffold ainda não foi implementado.
