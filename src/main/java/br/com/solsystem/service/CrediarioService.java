package br.com.solsystem.service;

import br.com.solsystem.dto.request.RecebimentoRequest;
import br.com.solsystem.dto.response.ContaReceberResponse;
import br.com.solsystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CrediarioService {
    private final ContaReceberRepository contaRepository;
    private final RecebimentoRepository recebimentoRepository;
    private final SessaoCaixaRepository sessaoRepository;
    private final MovimentoCaixaRepository movimentoCaixaRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true) public List<ContaReceberResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public List<ContaReceberResponse> listarPorCliente(UUID clientePublicId) { throw todo(); }
    @Transactional(readOnly = true) public List<ContaReceberResponse> listarVencidas() { throw todo(); }

    @Transactional
    public ContaReceberResponse receber(UUID contaPublicId, RecebimentoRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 9: aceitar parcial, impedir excesso, atualizar parcela/conta e gerar movimento de caixa");
    }

    private UnsupportedOperationException todo() { return new UnsupportedOperationException("TODO ETAPA 9: implementar consultas do crediário"); }
}
