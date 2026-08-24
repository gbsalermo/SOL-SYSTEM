package br.com.solsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "caixas")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Caixa extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column(nullable = false)
    private boolean ativo = true;
}
