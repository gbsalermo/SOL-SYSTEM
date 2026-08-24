package br.com.solsystem.repository;

import br.com.solsystem.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByPublicId(UUID publicId);
    Optional<Usuario> findByLoginIgnoreCase(String login);
    boolean existsByLoginIgnoreCase(String login);
}
