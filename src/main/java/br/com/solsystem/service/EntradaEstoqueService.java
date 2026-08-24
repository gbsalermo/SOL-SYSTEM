package br.com.solsystem.service;

import br.com.solsystem.dto.request.EntradaEstoqueRequest;
import br.com.solsystem.dto.response.EntradaEstoqueResponse;
import br.com.solsystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EntradaEstoqueService {
    private final EntradaEstoqueRepository entradaRepository;
    private final FornecedorRepository fornecedorRepository;
    private final VariacaoProdutoRepository variacaoRepository;
    private final EstoqueRepository estoqueRepository;
    private final MovimentoEstoqueRepository movimentoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public EntradaEstoqueResponse registrar(EntradaEstoqueRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 4: entrada + custo + estoque + movimentos em transação única");
    }

    @Transactional(readOnly = true) public List<EntradaEstoqueResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public EntradaEstoqueResponse buscar(UUID publicId) { throw todo(); }

    private UnsupportedOperationException todo() { return new UnsupportedOperationException("TODO ETAPA 4: implementar consulta de entradas"); }
}
