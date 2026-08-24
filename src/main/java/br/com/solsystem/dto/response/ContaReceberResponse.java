package br.com.solsystem.dto.response;

import br.com.solsystem.enums.StatusContaReceber;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ContaReceberResponse(
        UUID publicId,
        UUID clientePublicId,
        UUID vendaPublicId,
        BigDecimal valorOriginal,
        BigDecimal valorPago,
        BigDecimal saldoDevedor,
        LocalDate vencimento,
        StatusContaReceber status
) {
}
