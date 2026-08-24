package br.com.solsystem.repository;

import br.com.solsystem.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByPublicId(UUID publicId);
    Optional<Funcionario> findByCpf(String cpf);
}
