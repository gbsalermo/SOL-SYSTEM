package br.com.solsystem.dto.request;

import br.com.solsystem.enums.PerfilAcesso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record AtualizarUsuarioRequest(
        @NotBlank String login,
        @NotEmpty Set<PerfilAcesso> perfis,
        boolean ativo
) {
}
