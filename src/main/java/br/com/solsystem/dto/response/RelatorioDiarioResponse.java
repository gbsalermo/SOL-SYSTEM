package br.com.solsystem.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RelatorioDiarioResponse(
        LocalDate data,
        long quantidadeVendas,
        long itensVendidos,
        BigDecimal vendasBrutas,
        BigDecimal descontos,
        BigDecimal receitaLiquida,
        BigDecimal custoMercadorias,
        BigDecimal lucroBruto,
        BigDecimal despesas,
        BigDecimal resultadoOperacional,
        BigDecimal novasDividas,
        BigDecimal recebimentosCrediario,
        BigDecimal totalVencido,
        long cancelamentos,
        BigDecimal valorCancelado
) {
}
