package br.com.solsystem.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemVendaRequest(
        @NotNull UUID variacaoPublicId,
        @Min(1) int quantidade,
        @DecimalMin("0.00") BigDecimal desconto
) {
}
