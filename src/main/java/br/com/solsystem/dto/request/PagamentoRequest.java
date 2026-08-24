package br.com.solsystem.dto.request;

import br.com.solsystem.enums.FormaPagamento;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PagamentoRequest(
        @NotNull FormaPagamento formaPagamento,
        @NotNull @DecimalMin(value = "0.01") BigDecimal valor
) {
}
