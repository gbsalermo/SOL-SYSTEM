package br.com.solsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CancelamentoVendaRequest(
        @NotBlank String motivo,
        @NotNull UUID usuarioResponsavelPublicId
) {
}
