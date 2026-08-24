package br.com.solsystem.dto.response;

import java.util.UUID;

public record EstoqueResponse(
        UUID estoquePublicId,
        UUID variacaoPublicId,
        String produto,
        String tamanho,
        String cor,
        String sku,
        Integer quantidadeAtual,
        Integer estoqueMinimo,
        boolean estoqueBaixo
) {
}
