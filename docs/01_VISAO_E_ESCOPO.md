# 01 — Visão e Escopo

## Status

Escopo do MVP definido. Mudanças de escopo devem ser registradas antes de implementação e refletidas no roadmap/continuidade quando afetarem ordem ou dependências.

## Objetivo

O SOL System é um sistema de gestão para uma única loja física familiar de roupas. O objetivo é substituir controles dispersos por um histórico confiável de vendas, estoque, caixa, custos, resultado, clientes, dívidas e ações dos funcionários.

## Usuários do sistema

- proprietário/administrador;
- gerente;
- caixa;
- vendedor;
- responsável por estoque.

`Cliente` é pessoa cadastrada para fins comerciais e de crediário, **não usuário autenticado**.

## Dentro do MVP

- cadastro de produtos, categorias e variações;
- estoque por cor/tamanho/SKU;
- entrada e saída de mercadoria;
- fornecedores;
- venda presencial;
- múltiplas formas de pagamento na mesma venda;
- venda avulsa sem Cliente quando não houver crediário;
- clientes e histórico comercial;
- classificação padrão/VIP/lista negra;
- crediário por conta, parcelas e pagamentos parciais;
- funcionários, login e perfis;
- abertura/fechamento de caixa, sangria e suprimento;
- despesas;
- cancelamento/estorno;
- custo, lucro bruto e resultado operacional;
- auditoria;
- relatórios;
- resumo diário via Telegram.

## Fora do MVP

- e-commerce;
- carrinho público;
- gateway de pagamento online;
- entrega/frete;
- marketplace;
- landing page pública;
- multiempresa/multiloja;
- emissão fiscal integrada;
- contabilidade completa.

## Evoluções possíveis

Landing page, catálogo público, múltiplas lojas, comissão de vendedor, promoções, etiquetas/código de barras, impressão de comprovantes, exportações e integrações fiscais podem ser adicionados depois sem alterar o núcleo histórico do domínio.

## Critério de sucesso do MVP

A operação da loja deve conseguir registrar o ciclo completo **entrada → estoque → venda/crediário → caixa → relatório**, preservando rastreabilidade, autorização e histórico.