package br.com.solsystem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Produto extends BaseEntity {

    /** TODO ETAPA 2: Produto é o conceito comercial; estoque/preço pertencem à variação. */
    @Column(nullable = false, length = 180)
    private String nome;

    @Column(length = 1000)
    private String descricao;

    @Column(length = 120)
    private String marca;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private boolean ativo = true;
}
