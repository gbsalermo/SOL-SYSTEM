package br.com.solsystem.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record FecharCaixaRequest(
        @NotNull UUID funcionarioPublicId,
        @NotNull @DecimalMin("0.00") BigDecimal valorContado
) {
}
