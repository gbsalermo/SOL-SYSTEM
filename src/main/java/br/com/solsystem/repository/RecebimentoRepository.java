package br.com.solsystem.repository;

import br.com.solsystem.entity.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
    List<Recebimento> findAllByContaReceberPublicIdOrderByRecebidoEmDesc(UUID contaPublicId);
}
