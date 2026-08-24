package br.com.solsystem.repository;

import br.com.solsystem.entity.VariacaoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VariacaoProdutoRepository extends JpaRepository<VariacaoProduto, Long> {
    Optional<VariacaoProduto> findByPublicId(UUID publicId);
    Optional<VariacaoProduto> findBySku(String sku);
    Optional<VariacaoProduto> findByCodigoBarras(String codigoBarras);
}
