package br.com.solsystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FornecedorRequest(
        @NotBlank String nomeRazaoSocial,
        String nomeFantasia,
        String cpfCnpj,
        String telefone,
        @Email String email,
        String observacoes
) {
}
