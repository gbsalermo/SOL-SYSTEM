package br.com.solsystem.dto.response;

import br.com.solsystem.enums.StatusCaixa;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record CaixaResponse(
        UUID sessaoPublicId,
        UUID caixaPublicId,
        StatusCaixa status,
        OffsetDateTime aberturaEm,
        OffsetDateTime fechamentoEm,
        BigDecimal valorInicial,
        BigDecimal valorEsperado,
        BigDecimal valorContado,
        BigDecimal diferenca
) {
}
