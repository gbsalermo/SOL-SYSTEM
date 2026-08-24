package br.com.solsystem.service;

import br.com.solsystem.dto.request.LoginRequest;
import br.com.solsystem.dto.response.AuthResponse;
import br.com.solsystem.repository.UsuarioRepository;
import br.com.solsystem.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        throw new UnsupportedOperationException("TODO ETAPA 1.5: validar login/hash, bloqueio, tentativas e emitir JWT");
    }
}
