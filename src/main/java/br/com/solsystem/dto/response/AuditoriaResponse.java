package br.com.solsystem.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;

public record AuditoriaResponse(
        UUID publicId, UUID usuarioPublicId, String acao, String entidade,
        UUID publicIdEntidade, String detalhes, String correlationId, OffsetDateTime criadoEm
) {
}
