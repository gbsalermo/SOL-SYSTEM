package br.com.solsystem.service;

import br.com.solsystem.dto.request.CancelamentoVendaRequest;
import br.com.solsystem.dto.request.VendaRequest;
import br.com.solsystem.dto.response.VendaResponse;
import br.com.solsystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendaService {
    private final VendaRepository vendaRepository;
    private final VariacaoProdutoRepository variacaoRepository;
    private final EstoqueRepository estoqueRepository;
    private final MovimentoEstoqueRepository movimentoEstoqueRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final SessaoCaixaRepository sessaoCaixaRepository;
    private final MovimentoCaixaRepository movimentoCaixaRepository;
    private final ContaReceberRepository contaReceberRepository;
    private final CancelamentoVendaRepository cancelamentoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public VendaResponse realizar(VendaRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 6/7: snapshot preço/custo, lock estoque, pagamentos, crediário e caixa de forma atômica");
    }

    @Transactional(readOnly = true) public List<VendaResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public VendaResponse buscar(UUID publicId) { throw todo(); }

    @Transactional
    public VendaResponse cancelar(UUID publicId, CancelamentoVendaRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 10: estornar venda/estoque/caixa/crediário e auditar numa única transação");
    }

    private UnsupportedOperationException todo() { return new UnsupportedOperationException("TODO ETAPA 6: implementar consultas de venda"); }
}
