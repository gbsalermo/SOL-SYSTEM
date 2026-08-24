package br.com.solsystem.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record EntradaEstoqueRequest(
        UUID fornecedorPublicId,
        String numeroDocumento,
        String observacao,
        @NotNull UUID usuarioResponsavelPublicId,
        @NotEmpty List<@Valid ItemEntradaRequest> itens
) {
}
