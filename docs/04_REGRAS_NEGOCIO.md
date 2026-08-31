# 04 — Regras de Negócio

## Uso deste documento

Estas regras são **invariantes do domínio**. Uma implementação que compila mas viola uma regra abaixo não está concluída. Decisões ainda não fechadas ficam em `12_DECISOES_PENDENTES.md`.

## RN-EST — Estoque

1. Estoque pertence à variação, não ao produto genérico.
2. Quantidade nunca pode ficar negativa.
3. Toda alteração gera `MovimentoEstoque` na mesma transação.
4. Ajuste negativo exige motivo e usuário responsável.
5. Venda deve revalidar estoque dentro da transação.
6. Concorrência na última unidade deve resultar em uma venda confirmada e outra resposta `409 Conflict`.

## RN-ENT — Entrada

1. Entrada recebida não pode ser editada como rascunho.
2. Cada item altera estoque e gera movimento.
3. Proposta atual de cálculo de custo: **custo médio ponderado**. Ainda precisa confirmação da loja antes da Etapa 4.
4. Cancelamento futuro de entrada deve ser operação de reversão, não DELETE.

## RN-VEN — Venda

1. Venda precisa de pelo menos um item.
2. Item precisa de quantidade positiva.
3. Snapshot de preço e custo é gravado em `ItemVenda`.
4. Soma dos pagamentos deve fechar o total; a parte em crediário cria dívida.
5. Venda com crediário exige Cliente.
6. Venda sem Cliente é permitida para pagamento imediato.
7. Venda finalizada não é editada diretamente.
8. Cancelamento exige motivo, autorização e auditoria.
9. Vendas em dinheiro/recebimentos físicos exigem sessão de caixa aberta.

## RN-CLI — Cliente, VIP e lista negra

1. Classificação inicial: `PADRAO`.
2. `LISTA_VIP` significa cliente de confiança com crediário aprovado pelo proprietário/administração.
3. Promoção para `LISTA_VIP` e liberação/aumento de limite exigem perfil `ADMINISTRADOR`.
4. `LISTA_NEGRA` bloqueia novas vendas em crediário.
5. Colocar/retirar cliente das listas exige motivo e auditoria.
6. Histórico financeiro nunca é apagado quando a classificação muda.
7. Dívida é soma das contas abertas/vencidas; não duplicar saldo no Cliente.
8. O perfil autorizado a aplicar/remover `LISTA_NEGRA` além do ADMINISTRADOR ainda é decisão pendente.

## RN-CRE — Crediário

1. Permitir pagamento parcial.
2. Nunca receber valor maior que saldo devedor.
3. Conta paga não recebe novo pagamento.
4. Recebimento atualiza conta/parcela e caixa na mesma transação.
5. Atraso muda status para `VENCIDA` sem apagar histórico.
6. Nova dívida deve respeitar limite de crédito disponível.
7. Venda parcialmente paga que for cancelada exige política explícita de devolução/estorno; não zerar saldo silenciosamente.

## RN-CXA — Caixa

1. Um caixa só pode possuir uma sessão aberta.
2. Sessão fechada não recebe movimento.
3. Sangria/suprimento exigem valor positivo, motivo e usuário.
4. Fechamento calcula valor esperado, valor contado e diferença.
5. Divergência permanece registrada; não corrigir o histórico para fazer bater.

## RN-CAN — Cancelamento

Cancelamento de venda é uma transação única:

```text
validar autorização
→ marcar venda cancelada
→ devolver estoque
→ gerar movimentos de estoque
→ estornar pagamentos/movimentos
→ tratar conta a receber/recebimentos
→ registrar CancelamentoVenda
→ registrar Auditoria
```

Falhou uma parte: rollback de tudo.

## RN-FIN — Resultado

- Receita líquida = vendas - descontos/cancelamentos aplicáveis.
- Lucro bruto = receita de venda - custo congelado dos itens.
- Resultado operacional = lucro bruto - despesas registradas no período.
- Não chamar lucro bruto ou resultado operacional de lucro líquido contábil.