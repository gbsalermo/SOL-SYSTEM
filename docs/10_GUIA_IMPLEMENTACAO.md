# 10 — Guia de Implementação

## Como usar os arquivos scaffold

Procure por `TODO ETAPA`. O arquivo já informa o relacionamento, dependências e assinatura; implemente apenas o módulo da etapa atual.

## Fluxo de uma feature

Exemplo: criar Categoria.

1. revisar Entity e constraints;
2. criar constructor/factory controlado;
3. validar DTO;
4. implementar Repository necessário;
5. implementar Service;
6. mapear Entity -> Response;
7. validar Controller/status HTTP;
8. testar Service;
9. testar endpoint;
10. atualizar `CONTINUIDADE.md`.

## Constructors/factories

Entidades estão com construtor JPA protegido. Adicione factories/constructors públicos somente quando chegar à etapa. Evite setters indiscriminados em campos históricos.

Exemplo conceitual:

```java
Produto.criar(nome, descricao, marca, categoria)
```

é preferível a montar objeto inconsistente campo por campo no Controller.

## Mapper

Pode começar com métodos privados no Service ou classes mapper simples. Não adicionar MapStruct antes de existir repetição real.

## Transação

Use `@Transactional` no Service que coordena regra. Nunca espalhar uma venda entre várias transações independentes.

## Public ID

Repository pode usar `Long` internamente, mas Service/Controller devem localizar recursos por `UUID publicId`.

## Soft delete

Cadastros mestres usam `ativo=false`. Eventos históricos não são apagados.

## Checklist antes de concluir uma etapa

- regra de negócio coberta;
- nenhuma Entity retornada pelo Controller;
- nenhum Long id em DTO;
- validação de null/valor negativo;
- autorização correta;
- transação correta;
- erro HTTP adequado;
- testes verdes;
- documentação atualizada.
