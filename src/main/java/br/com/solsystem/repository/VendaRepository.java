package br.com.solsystem.repository;

import br.com.solsystem.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    Optional<Venda> findByPublicId(UUID publicId);
    Optional<Venda> findByNumeroVenda(String numeroVenda);
    List<Venda> findAllByClientePublicId(UUID clientePublicId);
}
