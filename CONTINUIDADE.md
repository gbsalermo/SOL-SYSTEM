# SOL System — Continuidade Oficial

## Regra deste arquivo

Este é o **ponto de retomada oficial** do projeto. Outra IA ou desenvolvedor deve começar por aqui e não deve inferir avanço apenas porque classes, rotas ou DTOs já existem.

Ordem oficial das etapas: `docs/09_ROADMAP_ETAPAS.md`.

## Estado atual

**Data da revisão:** 31/08/2026  
**Último commit de código revisado:** `e9cbc4f7b304f873fbfce76b4de5765f641dd850` — `security: separate user update from password reset and add CI`  
**Etapa concluída:** ETAPA 0 — Scaffold ✅  
**Etapa em execução:** **ETAPA 1.1 — Fundação técnica / validação do scaffold**  
**Etapas posteriores:** não iniciadas.

Não foram encontrados commits posteriores a 24/08/2026 na revisão de 31/08/2026.

## O que existe de verdade no repositório

### Fundação já implementada

- Maven e dependências.
- Java 21 / Spring Boot 4.1.0.
- `BaseEntity` com `Long id`, `UUID publicId`, `@Version` e timestamps.
- profiles `dev` (H2) e `postgres` (PostgreSQL).
- `context-path: /api`; controllers em `/v1`, resultando em API externa `/api/v1/...`.
- estrutura de entidades e relacionamentos.
- repositories.
- DTOs request/response.
- controllers e rotas-base.
- `SecurityFilterChain` fechado por padrão.
- `PasswordEncoder` BCrypt.
- `JwtService` e `JwtAuthenticationFilter` estruturados, mas ainda não implementados funcionalmente.
- tratamento global de erros; `UnsupportedOperationException` do scaffold retorna `501`.
- correlation ID.
- scheduler/Telegram estruturados.
- workflow GitHub Actions com `mvn test`.
- documentação técnica.

### O que **não** deve ser considerado implementado

- criação real de funcionários/usuários;
- bootstrap do primeiro administrador;
- login e JWT funcionais;
- controle de tentativas/bloqueio;
- matriz completa de autorização testada;
- CRUDs de catálogo, estoque, fornecedores, clientes, vendas, caixa, crediário etc.;
- regras transacionais de negócio;
- migrations Flyway do domínio;
- relatórios funcionais;
- envio Telegram funcional;
- suíte de testes do domínio.

A maioria dos services ainda lança `UnsupportedOperationException` com `TODO ETAPA ...`.

## Validação conhecida

Há apenas `SolSystemApplicationTests` com teste de carregamento de contexto. O workflow `.github/workflows/ci.yml` existe, mas **não havia execução registrada para o commit atual** na revisão documental de 31/08/2026.

Consequência: não afirmar que `mvn test`, subida do profile `dev` ou schema H2 estão validados até executar a Etapa 1.1.

## Decisões oficiais já fechadas

- arquitetura: monólito modular simples;
- API externa: `/api/v1/...`;
- `Long id`: somente banco/backend;
- `UUID publicId`: API, DTOs, URLs e integrações;
- Cliente não autentica;
- Funcionário pode possuir `Usuario`;
- administrador é `PerfilAcesso.ADMINISTRADOR`;
- senha apenas em `senhaHash`;
- Entity JPA não é resposta HTTP;
- estoque pertence a `VariacaoProduto`;
- toda alteração de estoque gera `MovimentoEstoque`;
- toda alteração financeira do caixa gera `MovimentoCaixa`;
- venda finalizada não é apagada/editada diretamente;
- preço e custo são congelados em `ItemVenda`;
- dívida vem de `ContaReceber`, nunca de campo duplicado em Cliente;
- `LISTA_VIP` e `LISTA_NEGRA` são estados do mesmo Cliente;
- aprovação VIP/liberação ou aumento de crédito exige `ADMINISTRADOR`;
- lista negra bloqueia novo crediário;
- venda sem cliente é permitida para pagamento imediato, mas crediário exige Cliente;
- relatório é calculado internamente; Telegram é apenas canal de entrega;
- secrets ficam fora do Git.

## Próxima tarefa exata — ETAPA 1.1

Executar **somente** a Etapa 1.1:

1. rodar `mvn test`;
2. corrigir qualquer falha de compilação/contexto antes de continuar;
3. subir a aplicação com profile `dev`;
4. validar `/api/actuator/health` e Swagger;
5. inspecionar o schema H2 gerado e relacionamentos principais;
6. validar que o `context-path /api` + mappings `/v1` produzem `/api/v1/...`;
7. revisar entidades necessárias às Etapas 1.2/1.3 (`Funcionario`, `Usuario` e dependências diretas);
8. substituir construção inconsistente por constructors/factories controlados onde necessário;
9. adicionar testes mínimos para essas factories/invariantes;
10. atualizar este arquivo e marcar 1.1 concluída no roadmap somente após testes verdes.

### Critério de conclusão da 1.1

- projeto compila;
- `mvn test` verde;
- aplicação inicia em `dev`;
- schema H2 é coerente com o domínio atual;
- health/Swagger acessíveis conforme configuração;
- entidades da fundação de segurança podem ser criadas de forma válida sem setters indiscriminados;
- nenhum avanço de regra de negócio de Produto/Venda/Caixa foi feito por antecipação.

## Depois da 1.1

> **ETAPA 1.2 — implementar `FuncionarioService` mínimo e bootstrap seguro do primeiro administrador.**

Não iniciar 1.2 antes da validação explícita da 1.1.

## Como atualizar a continuidade

Ao concluir cada subetapa:

1. marcar o item no roadmap;
2. registrar testes executados e resultado;
3. mover decisões resolvidas de `12_DECISOES_PENDENTES.md` para o documento definitivo;
4. registrar qualquer divergência encontrada entre código e docs;
5. escrever a próxima tarefa exata;
6. fazer commit.