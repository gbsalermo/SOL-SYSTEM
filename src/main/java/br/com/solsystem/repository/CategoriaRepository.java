package br.com.solsystem.repository;

import br.com.solsystem.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByPublicId(UUID publicId);
    boolean existsByNomeIgnoreCase(String nome);
}
