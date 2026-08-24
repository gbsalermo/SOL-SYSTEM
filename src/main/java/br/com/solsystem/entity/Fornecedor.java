package br.com.solsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fornecedores")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fornecedor extends BaseEntity {

    @Column(name = "nome_razao_social", nullable = false, length = 180)
    private String nomeRazaoSocial;

    @Column(name = "nome_fantasia", length = 180)
    private String nomeFantasia;

    @Column(name = "cpf_cnpj", length = 20)
    private String cpfCnpj;

    @Column(length = 30)
    private String telefone;

    @Column(length = 180)
    private String email;

    @Column(length = 1000)
    private String observacoes;

    @Column(nullable = false)
    private boolean ativo = true;
}
