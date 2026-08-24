package br.com.solsystem.dto.request;

import br.com.solsystem.enums.FormaPagamento;
import br.com.solsystem.enums.TipoDespesa;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record DespesaRequest(
        @NotBlank String descricao,
        @NotNull TipoDespesa tipo,
        @NotNull @DecimalMin(value = "0.01") BigDecimal valor,
        @NotNull FormaPagamento formaPagamento,
        UUID sessaoCaixaPublicId,
        @NotNull UUID usuarioResponsavelPublicId,
        String observacao
) {
}
