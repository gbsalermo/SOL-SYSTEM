package br.com.solsystem.dto.request;

import br.com.solsystem.enums.ClassificacaoCliente;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ClienteRequest(
        @NotBlank String nome,
        String cpf,
        String telefone,
        @Email String email,
        LocalDate dataNascimento,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep,
        ClassificacaoCliente classificacao,
        boolean crediarioLiberado,
        @DecimalMin("0.00") BigDecimal limiteCredito,
        String motivoClassificacao,
        String observacoes
) {
}
