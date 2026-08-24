package br.com.solsystem.dto.request;

import br.com.solsystem.enums.FormaPagamento;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record RecebimentoRequest(
        UUID parcelaPublicId,
        @NotNull @DecimalMin(value = "0.01") BigDecimal valor,
        @NotNull FormaPagamento formaPagamento,
        @NotNull UUID sessaoCaixaPublicId,
        @NotNull UUID usuarioResponsavelPublicId,
        String observacao
) {
}
