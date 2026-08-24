package br.com.solsystem.repository;

import br.com.solsystem.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByPublicId(UUID publicId);
    List<Produto> findAllByAtivoTrue();
}
