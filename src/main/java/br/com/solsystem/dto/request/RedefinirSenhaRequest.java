package br.com.solsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RedefinirSenhaRequest(
        @NotBlank @Size(min = 8, max = 100) String novaSenha
) {
}
