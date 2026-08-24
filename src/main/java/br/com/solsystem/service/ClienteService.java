package br.com.solsystem.service;

import br.com.solsystem.dto.request.ClassificarClienteRequest;
import br.com.solsystem.dto.request.ClienteRequest;
import br.com.solsystem.dto.response.ClienteResponse;
import br.com.solsystem.repository.ClienteRepository;
import br.com.solsystem.repository.ContaReceberRepository;
import br.com.solsystem.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ContaReceberRepository contaReceberRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional public ClienteResponse criar(ClienteRequest request) { throw todo(); }
    @Transactional(readOnly = true) public List<ClienteResponse> listar() { throw todo(); }
    @Transactional(readOnly = true) public ClienteResponse buscar(UUID publicId) { throw todo(); }
    @Transactional public ClienteResponse atualizar(UUID publicId, ClienteRequest request) { throw todo(); }

    @Transactional
    public ClienteResponse classificar(UUID publicId, ClassificarClienteRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 5: validar autoridade; VIP libera crédito, LISTA_NEGRA bloqueia crediário; auditar mudança");
    }

    @Transactional public void desativar(UUID publicId) { throw todo(); }

    private UnsupportedOperationException todo() { return new UnsupportedOperationException("TODO ETAPA 5: implementar CRUD/ficha financeira do cliente"); }
}
