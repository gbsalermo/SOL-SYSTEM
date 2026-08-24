package br.com.solsystem.service;

import br.com.solsystem.dto.request.FuncionarioRequest;
import br.com.solsystem.dto.response.FuncionarioResponse;
import br.com.solsystem.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository repository;

    @Transactional public FuncionarioResponse criar(FuncionarioRequest request) { throw todo(); }
    @Transactional(readOnly = true) public List<FuncionarioResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public FuncionarioResponse buscar(UUID publicId) { throw todo(); }
    @Transactional public FuncionarioResponse atualizar(UUID publicId, FuncionarioRequest request) { throw todo(); }
    @Transactional public void desativar(UUID publicId) { throw todo(); }

    private UnsupportedOperationException todo() { return new UnsupportedOperationException("TODO ETAPA 1/5: implementar CRUD de funcionário sem expor CPF indiscriminadamente"); }
}
