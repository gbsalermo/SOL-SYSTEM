package br.com.solsystem.repository;

import br.com.solsystem.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    Optional<Despesa> findByPublicId(UUID publicId);
}
