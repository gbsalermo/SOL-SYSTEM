package br.com.solsystem.report;

import br.com.solsystem.dto.response.RelatorioDiarioResponse;
import br.com.solsystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RelatorioService {
    private final VendaRepository vendaRepository;
    private final ContaReceberRepository contaReceberRepository;
    private final RecebimentoRepository recebimentoRepository;
    private final DespesaRepository despesaRepository;
    private final CancelamentoVendaRepository cancelamentoRepository;

    @Transactional(readOnly = true)
    public RelatorioDiarioResponse gerarDiario(LocalDate data) {
        throw new UnsupportedOperationException("TODO ETAPA 13: agregar vendas, custo, lucro, despesas, crediário e cancelamentos sem recalcular snapshots antigos");
    }
}
