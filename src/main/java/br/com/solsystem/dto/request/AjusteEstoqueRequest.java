package br.com.solsystem.dto.request;

import br.com.solsystem.enums.TipoMovimentoEstoque;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AjusteEstoqueRequest(
        @NotNull UUID variacaoPublicId,
        @Min(1) int quantidade,
        @NotNull TipoMovimentoEstoque tipo,
        @NotBlank String motivo,
        @NotNull UUID usuarioResponsavelPublicId
) {
}
