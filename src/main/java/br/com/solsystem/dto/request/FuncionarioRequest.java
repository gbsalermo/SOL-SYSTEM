package br.com.solsystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FuncionarioRequest(
        @NotBlank String nome,
        String cpf,
        String telefone,
        @Email String email,
        String cargo,
        LocalDate dataAdmissao
) {
}
