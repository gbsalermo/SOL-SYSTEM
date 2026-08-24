package br.com.solsystem.repository;

import br.com.solsystem.entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    List<Auditoria> findAllByEntidadeAndPublicIdEntidadeOrderByCriadoEmDesc(String entidade, UUID publicIdEntidade);
}
