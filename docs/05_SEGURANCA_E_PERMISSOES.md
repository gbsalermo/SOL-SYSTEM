# 05 — Segurança e Permissões

## Estado atual

O scaffold de segurança existe, mas autenticação completa ainda pertence à ETAPA 1.

Já existe:

- `SecurityFilterChain` stateless e fechado por padrão;
- `@EnableMethodSecurity`;
- `PasswordEncoder` com BCrypt;
- estrutura de `JwtService` e `JwtAuthenticationFilter`;
- DTOs de login/usuário;
- separação entre atualização de usuário e redefinição de senha;
- campos de bloqueio/tentativas em `Usuario`.

Ainda não considerar funcional:

- login real;
- emissão/validação JWT;
- controle de tentativas e bloqueio;
- bootstrap do primeiro administrador;
- CRUD administrativo de usuário;
- matriz de autorização comprovada por testes.

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
- segredo JWT/Telegram real no Git.

A redefinição de senha possui endpoint/DTO separado do update de login/perfis para impedir regravação acidental da senha.

## Identificadores

A API usa UUID `publicId`. O `Long id` não deve aparecer em JSON, URL ou integrações.

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

`Permissao` existe para evolução futura para RBAC mais granular. Não ampliar complexidade antes da necessidade.

## JWT — requisitos da Etapa 1.5

- token assinado;
- expiração;
- subject baseado em identificador/login controlado;
- roles/authorities;
- rejeitar usuário desativado ou temporariamente bloqueado;
- algoritmo definido pelo servidor;
- não logar token.

## Primeiro administrador

Não criar endpoint público de cadastro inicial. Implementar bootstrap controlado por ambiente/CLI/migration administrativa, apenas se não houver usuário, e torná-lo inoperante após bootstrap.

## Dados pessoais

CPF/telefone/endereço precisam ser recuperáveis; não simplesmente hashá-los. Proteger com controle de acesso, DTO mínimo, mascaramento, TLS, usuário restrito de banco, backup protegido e logs sanitizados.

## Brute force

`Usuario` possui `tentativasFalhas` e `bloqueadoAte`. Implementar política de bloqueio na Etapa 1 e testá-la sem registrar credenciais tentadas.