# 11 — Testes e Qualidade

## Estado atual

Na revisão de 31/08/2026 existe apenas:

```text
src/test/java/br/com/solsystem/SolSystemApplicationTests.java
```

com teste básico de carregamento do contexto.

Existe workflow GitHub Actions para executar `mvn -B test`, porém nenhuma execução do commit atual foi encontrada durante a revisão. A ETAPA 1.1 deve estabelecer a primeira validação real do scaffold.

## Pirâmide prática

### Unitários

Services, factories e regras: cálculos, classificações, limites, status e rejeições.

### Integração JPA

Repositories, relacionamentos, locks e constraints.

### Integração API

MockMvc/SpringBootTest para status, validação, autenticação e autorização.

### PostgreSQL real

Testcontainers a partir da Etapa 5.

## Cenários obrigatórios futuros

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
- limite de crédito é respeitado;
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
- usuário bloqueado não autentica;
- JWT expirado não autentica.

## Qualidade

Não considerar uma etapa concluída só porque retorna 200. Validar banco, efeitos colaterais, autorização, concorrência quando aplicável e cenários de erro.

## Registro de validação

Ao fechar uma etapa, `CONTINUIDADE.md` deve registrar quais comandos/testes foram executados e se passaram.