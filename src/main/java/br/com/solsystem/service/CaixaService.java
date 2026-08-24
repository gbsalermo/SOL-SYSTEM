package br.com.solsystem.service;

import br.com.solsystem.dto.request.*;
import br.com.solsystem.dto.response.CaixaResponse;
import br.com.solsystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CaixaService {
    private final CaixaRepository caixaRepository;
    private final SessaoCaixaRepository sessaoRepository;
    private final MovimentoCaixaRepository movimentoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional public CaixaResponse criarCaixa(CaixaRequest request) { throw todo("criar cadastro de caixa"); }
    @Transactional public CaixaResponse abrir(UUID caixaPublicId, AbrirCaixaRequest request) { throw todo("impedir duas sessões abertas e registrar valor inicial"); }
    @Transactional public CaixaResponse fechar(UUID sessaoPublicId, FecharCaixaRequest request) { throw todo("calcular esperado, contado e diferença sem apagar divergência"); }
    @Transactional public void sangria(UUID sessaoPublicId, MovimentoCaixaRequest request) { throw todo("registrar sangria como movimento histórico"); }
    @Transactional public void suprimento(UUID sessaoPublicId, MovimentoCaixaRequest request) { throw todo("registrar suprimento como movimento histórico"); }
    @Transactional(readOnly = true) public List<CaixaResponse> listarSessoes() { throw todo("listar sessões"); }

    private UnsupportedOperationException todo(String detalhe) { return new UnsupportedOperationException("TODO ETAPA 8: " + detalhe); }
}
