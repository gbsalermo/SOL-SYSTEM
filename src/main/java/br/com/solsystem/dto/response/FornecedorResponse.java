package br.com.solsystem.dto.response;

import java.util.UUID;

public record FornecedorResponse(
        UUID publicId, String nomeRazaoSocial, String nomeFantasia,
        String telefone, String email, boolean ativo
) {
}
