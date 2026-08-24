package br.com.solsystem.repository;

import br.com.solsystem.entity.CancelamentoVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CancelamentoVendaRepository extends JpaRepository<CancelamentoVenda, Long> {
    Optional<CancelamentoVenda> findByVendaPublicId(UUID vendaPublicId);
}
