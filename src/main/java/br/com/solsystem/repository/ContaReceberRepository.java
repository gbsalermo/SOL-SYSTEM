package br.com.solsystem.repository;

import br.com.solsystem.entity.ContaReceber;
import br.com.solsystem.enums.StatusContaReceber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContaReceberRepository extends JpaRepository<ContaReceber, Long> {
    Optional<ContaReceber> findByPublicId(UUID publicId);
    List<ContaReceber> findAllByClientePublicId(UUID clientePublicId);
    List<ContaReceber> findAllByStatus(StatusContaReceber status);
    List<ContaReceber> findAllByVencimentoBeforeAndStatusIn(LocalDate data, List<StatusContaReceber> status);
}
