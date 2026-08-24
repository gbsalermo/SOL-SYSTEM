package br.com.solsystem.service;

import br.com.solsystem.dto.request.AtualizarUsuarioRequest;
import br.com.solsystem.dto.request.RedefinirSenhaRequest;
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
    public UsuarioResponse atualizar(UUID publicId, AtualizarUsuarioRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 1.6: atualizar somente login/perfis/status; senha possui fluxo separado");
    }

    @Transactional
    public void redefinirSenha(UUID publicId, RedefinirSenhaRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 1.6: BCrypt da nova senha, invalidar credenciais anteriores se aplicável e exigir troca no próximo login");
    }

    @Transactional
    public void desativar(UUID publicId) {
        throw new UnsupportedOperationException("TODO ETAPA 1.6: soft disable de usuário");
    }
}
