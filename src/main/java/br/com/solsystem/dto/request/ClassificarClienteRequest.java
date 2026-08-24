package br.com.solsystem.dto.request;

import br.com.solsystem.enums.ClassificacaoCliente;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ClassificarClienteRequest(
        @NotNull ClassificacaoCliente classificacao,
        boolean crediarioLiberado,
        @DecimalMin("0.00") BigDecimal limiteCredito,
        @NotBlank String motivo,
        @NotNull UUID usuarioResponsavelPublicId
) {
}
