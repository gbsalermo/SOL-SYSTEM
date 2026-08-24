package br.com.solsystem.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record VariacaoProdutoRequest(
        String tamanho,
        String cor,
        @NotBlank String sku,
        String codigoBarras,
        @NotNull @DecimalMin("0.00") BigDecimal precoVenda,
        @NotNull @DecimalMin("0.00") BigDecimal custoInicial,
        Integer estoqueMinimo
) {
}
