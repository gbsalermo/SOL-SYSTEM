package br.com.solsystem.dto.response;

import br.com.solsystem.enums.StatusEntradaEstoque;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record EntradaEstoqueResponse(
        UUID publicId, UUID fornecedorPublicId, String numeroDocumento,
        OffsetDateTime dataEntrada, BigDecimal custoTotal, StatusEntradaEstoque status
) {
}
