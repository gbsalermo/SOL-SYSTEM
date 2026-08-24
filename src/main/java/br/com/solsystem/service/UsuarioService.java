package br.com.solsystem.service;

import br.com.solsystem.dto.request.UsuarioRequest;
import br.com.solsystem.dto.response.UsuarioResponse;
import br.com.solsystem.repository.FuncionarioRepository;
import br.com.solsystem.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioResponse criar(UsuarioRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 1.3: criar usuário, normalizar login e salvar somente senhaHash");
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponse> listar() {
        throw new UnsupportedOperationException("TODO ETAPA 1.6: listar usuários sem dados sensíveis");
    }

    @Transactional(readOnly = true)
    public UsuarioResponse buscar(UUID publicId) {
        throw new UnsupportedOperationException("TODO ETAPA 1.6: buscar usuário por publicId");
    }

    @Transactional
    public UsuarioResponse atualizar(UUID publicId, UsuarioRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 1.6: atualizar login/perfis sem regravar senha por acidente");
    }

    @Transactional
    public void desativar(UUID publicId) {
        throw new UnsupportedOperationException("TODO ETAPA 1.6: soft disable de usuário");
    }
}
