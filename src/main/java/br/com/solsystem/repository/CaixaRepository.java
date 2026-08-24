package br.com.solsystem.repository;

import br.com.solsystem.entity.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {
    Optional<Caixa> findByPublicId(UUID publicId);
}
