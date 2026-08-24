package br.com.solsystem.repository;

import br.com.solsystem.entity.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, Long> {
    List<MovimentoEstoque> findAllByVariacaoPublicIdOrderByCriadoEmDesc(UUID variacaoPublicId);
}
