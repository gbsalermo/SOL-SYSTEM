package br.com.solsystem.audit;

import br.com.solsystem.dto.response.AuditoriaResponse;
import br.com.solsystem.repository.AuditoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditoriaService {
    private final AuditoriaRepository repository;

    @Transactional
    public void registrar(String acao, String entidade, UUID publicIdEntidade, String detalhes) {
        throw new UnsupportedOperationException("TODO ETAPA 12: capturar usuário/IP/correlationId e sanitizar detalhes sensíveis");
    }

    @Transactional(readOnly = true)
    public List<AuditoriaResponse> buscar(String entidade, UUID publicIdEntidade) {
        throw new UnsupportedOperationException("TODO ETAPA 12: mapear histórico de auditoria");
    }
}
