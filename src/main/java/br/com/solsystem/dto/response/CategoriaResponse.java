package br.com.solsystem.dto.response;

import java.util.UUID;

public record CategoriaResponse(UUID publicId, String nome, String descricao, boolean ativo) {
}
