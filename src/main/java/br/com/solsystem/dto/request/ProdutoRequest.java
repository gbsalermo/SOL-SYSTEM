package br.com.solsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ProdutoRequest(
        @NotBlank @Size(max = 180) String nome,
        @Size(max = 1000) String descricao,
        @Size(max = 120) String marca,
        @NotNull UUID categoriaPublicId
) {
}
