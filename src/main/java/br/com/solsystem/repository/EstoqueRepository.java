package br.com.solsystem.repository;

import br.com.solsystem.entity.Estoque;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByPublicId(UUID publicId);
    Optional<Estoque> findByVariacaoPublicId(UUID variacaoPublicId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select e from Estoque e where e.variacao.publicId = :publicId")
    Optional<Estoque> findByVariacaoPublicIdForUpdate(@Param("publicId") UUID publicId);
}
