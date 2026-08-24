package br.com.solsystem.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record VendaRequest(
        UUID clientePublicId,
        @NotNull UUID funcionarioVendedorPublicId,
        @NotNull UUID sessaoCaixaPublicId,
        @NotEmpty List<@Valid ItemVendaRequest> itens,
        @DecimalMin("0.00") BigDecimal desconto,
        @NotEmpty List<@Valid PagamentoRequest> pagamentos,
        LocalDate vencimentoCrediario
) {
}
