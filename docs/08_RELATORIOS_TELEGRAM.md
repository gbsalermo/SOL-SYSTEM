# 08 — Relatórios e Telegram

## Separação obrigatória

```text
RelatorioService → calcula/agrega
TelegramService  → entrega
Scheduler         → agenda
```

Telegram não contém regra financeira.

## Resumo diário mínimo

- quantidade de vendas;
- itens vendidos;
- vendas brutas;
- descontos;
- receita líquida;
- custo das mercadorias vendidas;
- lucro bruto;
- despesas;
- resultado operacional;
- novas dívidas;
- recebimentos do crediário;
- total vencido;
- quantidade/valor de cancelamentos.

## Exemplo de mensagem

```text
📊 SOL — 24/08/2026

Vendas: 28 | R$ 5.420,00
Custo: R$ 2.710,00
Lucro bruto: R$ 2.710,00
Despesas: R$ 320,00
Resultado operacional: R$ 2.390,00

Novas dívidas: R$ 350,00
Recebido crediário: R$ 480,00
Em atraso: R$ 1.120,00

Cancelamentos: 2 | R$ 180,00
```

## Configuração

Token/chat ficam em variáveis de ambiente. `TELEGRAM_ENABLED=false` por padrão.

Scheduler está preparado para 19:00 em `America/Bahia`; o horário pode ser alterado sem recompilar.

## Confiabilidade

`NotificacaoEnvio` registra envio/falha/tentativas. Uma falha do Telegram não pode desfazer vendas nem interromper o caixa.
