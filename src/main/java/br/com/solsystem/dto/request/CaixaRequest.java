package br.com.solsystem.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CaixaRequest(
        @NotBlank String nome,
        String descricao
) {
}
