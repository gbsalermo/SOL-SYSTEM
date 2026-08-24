package br.com.solsystem.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record MovimentoCaixaRequest(
        @NotNull @DecimalMin(value = "0.01") BigDecimal valor,
        @NotBlank String descricao,
        @NotNull UUID usuarioResponsavelPublicId
) {
}
