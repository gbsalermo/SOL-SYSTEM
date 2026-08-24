package br.com.solsystem.repository;

import br.com.solsystem.entity.MovimentoCaixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MovimentoCaixaRepository extends JpaRepository<MovimentoCaixa, Long> {
    List<MovimentoCaixa> findAllBySessaoCaixaPublicIdOrderByCriadoEmAsc(UUID sessaoPublicId);
}
