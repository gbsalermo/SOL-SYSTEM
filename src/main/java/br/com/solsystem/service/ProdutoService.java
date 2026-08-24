package br.com.solsystem.service;

import br.com.solsystem.dto.request.ProdutoRequest;
import br.com.solsystem.dto.request.VariacaoProdutoRequest;
import br.com.solsystem.dto.response.ProdutoResponse;
import br.com.solsystem.repository.CategoriaRepository;
import br.com.solsystem.repository.EstoqueRepository;
import br.com.solsystem.repository.ProdutoRepository;
import br.com.solsystem.repository.VariacaoProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final VariacaoProdutoRepository variacaoRepository;
    private final CategoriaRepository categoriaRepository;
    private final EstoqueRepository estoqueRepository;

    @Transactional public ProdutoResponse criar(ProdutoRequest request) { throw todo(); }
    @Transactional public ProdutoResponse adicionarVariacao(UUID produtoPublicId, VariacaoProdutoRequest request) { throw todo(); }
    @Transactional(readOnly = true) public List<ProdutoResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public ProdutoResponse buscarVariacao(UUID variacaoPublicId) { throw todo(); }
    @Transactional(readOnly = true) public ProdutoResponse buscarPorCodigoBarras(String codigo) { throw todo(); }
    @Transactional public ProdutoResponse atualizar(UUID produtoPublicId, ProdutoRequest request) { throw todo(); }
    @Transactional public void desativar(UUID produtoPublicId) { throw todo(); }

    private UnsupportedOperationException todo() {
        return new UnsupportedOperationException("TODO ETAPA 2: implementar Produto/Variacao e criação automática de Estoque");
    }
}
