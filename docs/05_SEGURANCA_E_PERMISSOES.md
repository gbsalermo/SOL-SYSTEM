# 05 — Segurança e Permissões

## Modelo de pessoa x autenticação

- `Cliente`: cadastro comercial, sem senha/login.
- `Funcionario`: pessoa que trabalha na loja.
- `Usuario`: credencial vinculada a um Funcionário.
- `ADMINISTRADOR`: perfil do proprietário/administração; não é outra entidade.

## Senhas

Obrigatório:

```text
request recebe senha
→ PasswordEncoder
→ senhaHash
→ banco
```

Proibido:

- senha em texto puro no banco;
- senha/token em log;
- senha em DTO response;
- senha em Auditoria;
- segredo JWT/Telegram no Git.

## Identificadores

A API só usa UUID `publicId`. O `Long id` não deve aparecer em JSON, URL, logs de negócio ou integrações.

## Perfis iniciais

| Operação | Admin | Gerente | Caixa | Vendedor | Estoque |
|---|---:|---:|---:|---:|---:|
| Gerenciar usuários | ✓ |  |  |  |  |
| Aprovar VIP/crédito | ✓ |  |  |  |  |
| Ver auditoria | ✓ |  |  |  |  |
| Cancelar venda | ✓ | ✓ |  |  |  |
| Relatórios financeiros | ✓ | ✓ |  |  |  |
| Abrir/fechar caixa | ✓ | ✓ | ✓ |  |  |
| Registrar venda | ✓ | ✓ | ✓ | ✓ |  |
| Receber crediário | ✓ | ✓ | ✓ |  |  |
| Ajustar estoque | ✓ | ✓ |  |  | ✓ |
| Gerenciar fornecedor/entrada | ✓ | ✓ |  |  | ✓ |

`Permissao` já existe para evolução para RBAC mais granular.

## JWT

A estrutura está preparada, mas `JwtService` e `JwtAuthenticationFilter` são tarefas da Etapa 1. Requisitos:

- token assinado;
- expiração;
- subject baseado em identificador público/login controlado;
- roles/authorities;
- rejeitar usuário desativado/bloqueado;
- não aceitar algoritmo indicado pelo cliente;
- não logar token.

## Primeiro administrador

Não criar endpoint público de cadastro. Implementar bootstrap controlado por ambiente/CLI/migration administrativa, executado apenas se não houver usuário, e desabilitado depois.

## Dados pessoais

CPF/telefone/endereço não são senha e precisam ser recuperáveis; portanto não devem ser simplesmente hashados. Proteção vem de:

- controle de acesso;
- DTO mínimo;
- mascaramento quando perfil não precisa do dado completo;
- TLS em produção;
- banco com usuário restrito;
- backups protegidos;
- logs sanitizados;
- criptografia de disco/infraestrutura quando disponível.

## Brute force

`Usuario` já possui `tentativasFalhas` e `bloqueadoAte`. Implementar bloqueio progressivo na Etapa 1 e auditorar bloqueios sem registrar a senha tentada.
