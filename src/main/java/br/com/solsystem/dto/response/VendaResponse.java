package br.com.solsystem.dto.response;

import br.com.solsystem.enums.StatusVenda;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record VendaResponse(
        UUID publicId,
        String numeroVenda,
        UUID clientePublicId,
        StatusVenda status,
        BigDecimal subtotal,
        BigDecimal desconto,
        BigDecimal total,
        BigDecimal custoTotal,
        BigDecimal lucroBruto,
        OffsetDateTime finalizadaEm
) {
}
