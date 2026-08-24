package br.com.solsystem.service;

import br.com.solsystem.dto.request.DespesaRequest;
import br.com.solsystem.dto.response.DespesaResponse;
import br.com.solsystem.repository.DespesaRepository;
import br.com.solsystem.repository.MovimentoCaixaRepository;
import br.com.solsystem.repository.SessaoCaixaRepository;
import br.com.solsystem.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DespesaService {
    private final DespesaRepository despesaRepository;
    private final SessaoCaixaRepository sessaoRepository;
    private final MovimentoCaixaRepository movimentoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional public DespesaResponse registrar(DespesaRequest request) { throw todo(); }
    @Transactional(readOnly = true) public List<DespesaResponse> listar() { throw todo(); }
    @Transactional public void cancelar(UUID publicId, UUID usuarioResponsavelPublicId) { throw todo(); }

    private UnsupportedOperationException todo() { return new UnsupportedOperationException("TODO ETAPA 11: despesa + movimento de caixa + auditoria"); }
}
