package br.com.solsystem.dto.response;

import br.com.solsystem.enums.ClassificacaoCliente;

import java.math.BigDecimal;
import java.util.UUID;

public record ClienteResponse(
        UUID publicId,
        String nome,
        String telefone,
        String email,
        ClassificacaoCliente classificacao,
        boolean crediarioLiberado,
        BigDecimal limiteCredito,
        BigDecimal totalEmAberto,
        BigDecimal totalVencido,
        boolean ativo
) {
}
