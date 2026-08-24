package br.com.solsystem.service;

import br.com.solsystem.dto.request.FornecedorRequest;
import br.com.solsystem.dto.response.FornecedorResponse;
import br.com.solsystem.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FornecedorService {
    private final FornecedorRepository repository;

    @Transactional public FornecedorResponse criar(FornecedorRequest request) { throw todo(); }
    @Transactional(readOnly = true) public List<FornecedorResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public FornecedorResponse buscar(UUID publicId) { throw todo(); }
    @Transactional public FornecedorResponse atualizar(UUID publicId, FornecedorRequest request) { throw todo(); }
    @Transactional public void desativar(UUID publicId) { throw todo(); }

    private UnsupportedOperationException todo() { return new UnsupportedOperationException("TODO ETAPA 4: implementar CRUD de fornecedor"); }
}
