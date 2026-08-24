package br.com.solsystem.security;

import br.com.solsystem.entity.Usuario;
import br.com.solsystem.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLoginIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String[] roles = usuario.getPerfis().stream().map(Enum::name).toArray(String[]::new);
        return User.withUsername(usuario.getLogin())
                .password(usuario.getSenhaHash())
                .roles(roles)
                .disabled(!usuario.isAtivo())
                .build();
    }
}
