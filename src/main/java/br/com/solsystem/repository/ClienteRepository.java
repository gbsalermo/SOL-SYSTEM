package br.com.solsystem.repository;

import br.com.solsystem.entity.Cliente;
import br.com.solsystem.enums.ClassificacaoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByPublicId(UUID publicId);
    Optional<Cliente> findByCpf(String cpf);
    List<Cliente> findAllByClassificacao(ClassificacaoCliente classificacao);
}
