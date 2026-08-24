# 09 — Roadmap Oficial

## ETAPA 0 — Scaffold do projeto ✅

Estrutura, dependências, domínio, DTOs, repositories, services, controllers, security scaffold e docs criados.

## ETAPA 1 — Fundação e segurança

### 1.1
- rodar `mvn test`;
- subir profile dev;
- revisar schema H2;
- implementar constructors/factory methods das entities usadas.

### 1.2
- implementar `FuncionarioService` mínimo;
- bootstrap seguro do primeiro administrador, sem endpoint público.

### 1.3
- `UsuarioService.criar`;
- BCrypt;
- login normalizado/unique;
- troca de senha obrigatória.

### 1.4
- matriz Perfil -> Permissao;
- testes de autorização.

### 1.5
- `AuthService`;
- `JwtService`;
- `JwtAuthenticationFilter`;
- expiração e usuário bloqueado/desativado.

### 1.6
- CRUD administrativo de usuário;
- tentativas de login/bloqueio.

## ETAPA 2 — Categoria, Produto e Variação

CRUD vertical, SKU/código de barras, preço/custo e criação automática de Estoque.

## ETAPA 3 — Estoque

Consulta, ajustes, movimentos, estoque mínimo, pessimistic lock e testes concorrentes.

## ETAPA 4 — Fornecedor e Entrada

Fornecedor, itens de entrada, custo médio ponderado, atualização de estoque e histórico.

## ETAPA 5 — PostgreSQL e Flyway

Criar migrations, constraints/checks/índices, Testcontainers e `ddl-auto=validate`.

## ETAPA 6 — Clientes e classificação

CRUD, ficha financeira, VIP/lista negra, aprovação do proprietário, limite e auditoria.

## ETAPA 7 — Venda e pagamentos

Venda presencial, snapshot preço/custo, múltiplos pagamentos e baixa de estoque.

## ETAPA 8 — Caixa

Cadastro, sessão, abertura, fechamento, sangria, suprimento e integração com venda.

## ETAPA 9 — Crediário

Conta a receber, parcelas, pagamento parcial, inadimplência, limite e movimento de caixa.

## ETAPA 10 — Cancelamento/estorno

Fluxo transacional completo, incluindo casos parcialmente pagos.

## ETAPA 11 — Despesas

Saídas operacionais, cancelamento por estorno e impacto no resultado.

## ETAPA 12 — Auditoria

Usuário, ação, alvo, IP, correlation ID e sanitização de dados.

## ETAPA 13 — Relatórios

Diário, período, vendas, custo, lucro, caixa, estoque, clientes, produtos e vendedores.

## ETAPA 14 — Telegram

Bot API, formatação, scheduler, reenvio manual e log de falhas.

## ETAPA 15 — Qualidade e documentação final

Swagger detalhado, testes de integração, idempotência selecionada, health checks, backup/restore e revisão de segurança.

## ETAPA 16 — Frontend de gestão

Vue 3 + Vite + Router + Pinia + Axios; dashboard, venda, estoque, clientes, caixa, relatórios e administração.

## ETAPA 17 — Deploy

PostgreSQL persistente, HTTPS, secrets, backup, logs e operação.
