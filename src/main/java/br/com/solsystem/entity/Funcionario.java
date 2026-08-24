package br.com.solsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Funcionario extends BaseEntity {

    @Column(nullable = false, length = 180)
    private String nome;

    @Column(length = 14, unique = true)
    private String cpf;

    @Column(length = 30)
    private String telefone;

    @Column(length = 180)
    private String email;

    @Column(length = 100)
    private String cargo;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @Column(nullable = false)
    private boolean ativo = true;
}
