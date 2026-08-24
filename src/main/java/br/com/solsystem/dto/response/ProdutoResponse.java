package br.com.solsystem.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponse(
        UUID produtoPublicId,
        String nome,
        UUID variacaoPublicId,
        String tamanho,
        String cor,
        String sku,
        String codigoBarras,
        BigDecimal precoVenda,
        BigDecimal custoAtual,
        Integer quantidadeEstoque,
        boolean ativo
) {
}
