package br.com.solsystem.service;

import br.com.solsystem.dto.request.AjusteEstoqueRequest;
import br.com.solsystem.dto.response.EstoqueResponse;
import br.com.solsystem.repository.EstoqueRepository;
import br.com.solsystem.repository.MovimentoEstoqueRepository;
import br.com.solsystem.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;
    private final MovimentoEstoqueRepository movimentoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true) public List<EstoqueResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public EstoqueResponse buscarPorVariacao(UUID variacaoPublicId) { throw todo(); }

    @Transactional
    public EstoqueResponse ajustar(AjusteEstoqueRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 3: lock/revalidação, impedir negativo e registrar MovimentoEstoque na mesma transação");
    }

    private UnsupportedOperationException todo() {
        return new UnsupportedOperationException("TODO ETAPA 3: implementar consultas de estoque");
    }
}
