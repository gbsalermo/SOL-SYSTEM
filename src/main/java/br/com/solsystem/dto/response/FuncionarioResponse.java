package br.com.solsystem.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public record FuncionarioResponse(
        UUID publicId, String nome, String telefone, String email,
        String cargo, LocalDate dataAdmissao, boolean ativo
) {
}
