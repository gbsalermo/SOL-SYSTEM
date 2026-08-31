# 00 — Contexto para IA / Handoff do Projeto

## Para que serve este arquivo

Este documento permite que uma nova IA ou desenvolvedor entre no SOL System sem depender de conversas anteriores. Ele **não substitui** o roadmap, as regras de negócio ou `CONTINUIDADE.md`; serve como mapa de leitura e proteção contra decisões inventadas.

## Projeto em uma frase

API REST de gestão de uma **única loja física familiar de roupas**, cobrindo operação presencial, estoque, vendas, caixa, crediário, pessoas, auditoria e relatórios.

Não é e-commerce no MVP.

## Estado na revisão de 31/08/2026

| Item | Estado |
|---|---|
| ETAPA 0 — Scaffold | ✅ concluída |
| ETAPA 1.1 | ▶️ próxima/em execução |
| ETAPA 1.2+ | ⏸️ não iniciar ainda |
| Regras de negócio | documentadas, majoritariamente não implementadas |
| Controllers/DTOs/Repositories | scaffold criado |
| Services | maioria com `TODO ETAPA` + `UnsupportedOperationException` |
| Segurança | configuração base + BCrypt presentes; login/JWT pendentes |
| Testes | apenas `contextLoads` no momento |
| PostgreSQL/Flyway | profile preparado; migrations do domínio ainda pendentes |
| CI | workflow existe; execução do commit atual não confirmada na revisão |

Commit de código tomado como referência: `e9cbc4f7b304f873fbfce76b4de5765f641dd850`.

## Fontes de verdade

Quando precisar saber:

1. **onde estamos / o que fazer agora** → `CONTINUIDADE.md`;
2. **ordem oficial** → `09_ROADMAP_ETAPAS.md`;
3. **o que o negócio permite/proíbe** → `04_REGRAS_NEGOCIO.md`;
4. **o que ainda precisa de decisão humana** → `12_DECISOES_PENDENTES.md`;
5. **contratos e rotas planejadas** → `06_API_CRUDS.md`;
6. **modelo e relacionamentos** → `03_ENTIDADES_RELACIONAMENTOS.md`;
7. **como implementar** → `10_GUIA_IMPLEMENTACAO.md`;
8. **como provar qualidade** → `11_TESTES_QUALIDADE.md`.

Se houver conflito entre documentos, **não criar uma terceira versão**. Use `CONTINUIDADE.md` para o estado, o roadmap para a ordem e o documento temático para a decisão. Se o código estiver diferente, registrar a divergência antes de alterar o comportamento.

## Modelo mental do domínio

```text
Catálogo
Categoria -> Produto -> VariacaoProduto -> Estoque

Suprimento
Fornecedor -> EntradaEstoque -> ItemEntradaEstoque -> VariacaoProduto

Venda
Funcionario + SessaoCaixa + Cliente(opcional) -> Venda -> ItemVenda + Pagamento

Crediário
Cliente -> ContaReceber -> Parcela/Recebimento

Caixa
Caixa -> SessaoCaixa -> MovimentoCaixa

Histórico
MovimentoEstoque / CancelamentoVenda / Auditoria / NotificacaoEnvio
```

## Decisões que uma IA NÃO deve rediscutir sem motivo novo

- uma loja no MVP; sem multi-tenant/multiloja;
- monólito modular em camadas;
- Java 21 / Spring Boot 4.1.0;
- API externa `/api/v1`;
- `publicId` UUID em toda fronteira externa; `Long id` interno;
- `Cliente` sem login;
- `Usuario` vinculado a `Funcionario`;
- administrador é perfil, não entidade;
- senha apenas hash;
- estoque por variação/SKU;
- histórico financeiro/logístico não é apagado para “corrigir” fatos;
- venda finalizada é corrigida por cancelamento/estorno;
- custo/preço de venda são snapshot do momento;
- VIP e lista negra são classificação de Cliente;
- VIP/crédito exige aprovação administrativa;
- lista negra bloqueia crediário;
- Telegram não calcula relatório.

## Convenção de URL que pode confundir

No código, os controllers usam `/v1/...`. Em `application.yml`, o servidor usa `context-path: /api`. Assim:

```text
/v1/auth/login + /api = /api/v1/auth/login
```

Não remover `/api` nem duplicar `/api` nos controllers sem decisão explícita.

## Scaffold não significa implementação

Um arquivo existente pode ser apenas contrato. Exemplos atuais:

- `AuthService.login` → TODO Etapa 1.5;
- `UsuarioService.criar` → TODO Etapa 1.3;
- CRUD administrativo de usuário → TODO Etapa 1.6;
- `FuncionarioService` → ainda não funcional;
- demais services de domínio → etapas posteriores.

O handler converte esses TODOs lançados como `UnsupportedOperationException` em HTTP 501. Isso é comportamento temporário do scaffold.

## Regra para trabalhar no projeto

- não reorganizar o roadmap;
- não implementar módulo futuro “porque já está fácil”;
- não criar entidade/DTO paralelo se já existe scaffold;
- primeiro revisar o arquivo da etapa;
- implementar verticalmente;
- testar efeitos no banco e cenários de erro, não apenas HTTP 200;
- atualizar docs no mesmo ciclo da mudança;
- preservar compatibilidade com `publicId` e histórico imutável.

## Próxima ação

Executar `CONTINUIDADE.md` → **ETAPA 1.1**.

Quando 1.1 terminar, o próprio `CONTINUIDADE.md` deve apontar para 1.2. Não pular diretamente para Produto.