package br.com.solsystem.repository;

import br.com.solsystem.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByPublicId(UUID publicId);
    Optional<Fornecedor> findByCpfCnpj(String cpfCnpj);
}
