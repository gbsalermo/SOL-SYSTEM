package br.com.solsystem.repository;

import br.com.solsystem.entity.SessaoCaixa;
import br.com.solsystem.enums.StatusCaixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SessaoCaixaRepository extends JpaRepository<SessaoCaixa, Long> {
    Optional<SessaoCaixa> findByPublicId(UUID publicId);
    Optional<SessaoCaixa> findFirstByCaixaPublicIdAndStatus(UUID caixaPublicId, StatusCaixa status);
}
