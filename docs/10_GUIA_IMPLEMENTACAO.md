# 10 — Guia de Implementação

## Antes de escrever código

1. abrir `CONTINUIDADE.md`;
2. confirmar a subetapa atual em `09_ROADMAP_ETAPAS.md`;
3. ler o documento temático do módulo;
4. procurar `TODO ETAPA` nos arquivos existentes;
5. não criar arquivo paralelo se o scaffold já representa o papel necessário.

O número escrito em um TODO é orientação local. Se houver ambiguidade, a **ordem do roadmap e a continuidade prevalecem**.

## Como usar os arquivos scaffold

A estrutura já informa relacionamentos, dependências e assinaturas. Implementar somente o módulo da etapa atual, preservando contratos que já foram decididos.

## Fluxo de uma feature

Exemplo futuro: criar Categoria.

1. revisar Entity e constraints;
2. criar constructor/factory controlado;
3. validar DTO;
4. implementar Repository necessário;
5. implementar Service;
6. mapear Entity -> Response;
7. validar Controller/status HTTP/autorização;
8. testar Service;
9. testar endpoint e efeitos no banco;
10. atualizar `CONTINUIDADE.md`.

## Constructors/factories

Entidades estão com construtor JPA protegido. Adicione factories/constructors públicos somente quando chegar à etapa. Evite setters indiscriminados, principalmente em campos históricos e de segurança.

Exemplo conceitual:

```java
Produto.criar(nome, descricao, marca, categoria)
```

é preferível a montar objeto inconsistente no Controller.

## Mapper

Começar simples: métodos privados no Service ou classes mapper pequenas. Não adicionar MapStruct antes de existir repetição real.

## Transação

Use `@Transactional` no Service que coordena regra. Nunca espalhar uma venda, recebimento, cancelamento ou entrada entre transações independentes quando a regra exige atomicidade.

## Public ID

Repository pode usar `Long` internamente, mas Service/Controller devem localizar recursos externos por `UUID publicId`.

## Soft delete e histórico

- cadastros mestres: preferir `ativo=false`;
- fatos históricos: não apagar;
- correções: novo movimento, estorno ou cancelamento conforme domínio.

## Critério de erro

Não transformar qualquer falha em 400. Usar semântica da API (`404`, `409`, `422`, etc.). `501` é temporário e só representa método ainda scaffoldado.

## Checklist antes de concluir uma etapa

- regra de negócio coberta;
- nenhuma Entity retornada pelo Controller;
- nenhum `Long id` em DTO/URL;
- validação de null/valor negativo;
- autorização correta;
- transação correta;
- erro HTTP adequado;
- testes de sucesso e falha verdes;
- efeitos no banco conferidos;
- documentação atualizada;
- próxima tarefa escrita em `CONTINUIDADE.md`.