package br.com.solsystem.dto.response;

import br.com.solsystem.enums.PerfilAcesso;

import java.util.Set;
import java.util.UUID;

public record UsuarioResponse(
        UUID publicId,
        UUID funcionarioPublicId,
        String login,
        Set<PerfilAcesso> perfis,
        boolean ativo
) {
}
