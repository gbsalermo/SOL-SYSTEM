package br.com.solsystem.service;

import br.com.solsystem.dto.request.CategoriaRequest;
import br.com.solsystem.dto.response.CategoriaResponse;
import br.com.solsystem.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository repository;

    @Transactional public CategoriaResponse criar(CategoriaRequest request) { throw todo(); }
    @Transactional(readOnly = true) public List<CategoriaResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public CategoriaResponse buscar(UUID publicId) { throw todo(); }
    @Transactional public CategoriaResponse atualizar(UUID publicId, CategoriaRequest request) { throw todo(); }
    @Transactional public void desativar(UUID publicId) { throw todo(); }

    private UnsupportedOperationException todo() {
        return new UnsupportedOperationException("TODO ETAPA 2: implementar CRUD de Categoria + mapper DTO");
    }
}
