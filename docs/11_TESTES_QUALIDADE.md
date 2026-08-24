# 11 — Testes e Qualidade

## Pirâmide prática

### Unitários

Services: cálculos, classificações, limites, status e rejeições.

### Integração JPA

Repositories, relacionamentos, locks e constraints.

### Integração API

MockMvc/SpringBootTest para status, validação, autenticação e autorização.

### PostgreSQL real

Testcontainers a partir da Etapa 5.

## Cenários obrigatórios

### Estoque

- estoque 1, duas vendas simultâneas -> somente uma confirma;
- ajuste negativo que causaria -1 -> rejeitar;
- cada mudança gera movimento.

### Venda

- snapshot não muda quando preço/custo atual mudam;
- soma de pagamentos diferente do total -> rejeitar;
- venda a prazo sem cliente -> rejeitar;
- lista negra + crediário -> rejeitar.

### Caixa

- abrir caixa já aberto -> 409;
- movimento após fechamento -> rejeitar;
- diferença de fechamento permanece registrada.

### Crediário

- parcial reduz saldo;
- pagamento acima do saldo -> rejeitar;
- conta paga não recebe novo pagamento;
- VIP respeita limite;
- lista negra não recebe novo crédito.

### Cancelamento

- restaura estoque;
- estorna caixa;
- trata conta a receber;
- rollback completo se uma etapa falhar.

### Segurança

- senha nunca retornada;
- login inválido -> 401;
- vendedor não cancela venda;
- caixa não vê auditoria;
- usuário inativo não autentica;
- JWT expirado não autentica.

## Qualidade

Não considerar uma etapa concluída só porque retorna 200. Validar banco, efeitos colaterais e cenários de erro.
