package br.com.solsystem.repository;

import br.com.solsystem.entity.EntradaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EntradaEstoqueRepository extends JpaRepository<EntradaEstoque, Long> {
    Optional<EntradaEstoque> findByPublicId(UUID publicId);
}
