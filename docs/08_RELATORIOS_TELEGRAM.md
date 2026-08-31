# 08 — Relatórios e Telegram

## Estado atual

`RelatorioService`, `TelegramService`, scheduler e entidades de notificação estão scaffoldados. Cálculo real e envio real pertencem às Etapas 13 e 14.

Configuração inicial existente:

- `TELEGRAM_ENABLED=false` por padrão;
- token e chat por variáveis de ambiente;
- timezone `America/Bahia`;
- cron diário inicialmente às 19:00.

O horário ainda deve ser confirmado antes da Etapa 14.

## Separação obrigatória

```text
RelatorioService → calcula/agrega
TelegramService  → entrega
Scheduler         → agenda
```

Telegram não contém regra financeira e uma falha do canal não pode desfazer operação do negócio.

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

## Confiabilidade

`NotificacaoEnvio` deve registrar envio/falha/tentativas. Reenvio não pode duplicar fatos financeiros. Uma falha do Telegram deve permanecer isolada da transação de venda/caixa.