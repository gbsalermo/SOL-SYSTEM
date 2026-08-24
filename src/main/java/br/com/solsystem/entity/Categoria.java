package br.com.solsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Categoria extends BaseEntity {

    /** TODO ETAPA 2: validar unicidade lógica do nome e impedir exclusão física se houver produtos. */
    @Column(nullable = false, length = 120)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column(nullable = false)
    private boolean ativo = true;
}
