package br.com.solsystem.dto.response;

import br.com.solsystem.enums.StatusDespesa;
import br.com.solsystem.enums.TipoDespesa;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record DespesaResponse(
        UUID publicId, String descricao, TipoDespesa tipo, BigDecimal valor,
        OffsetDateTime dataDespesa, StatusDespesa status
) {
}
