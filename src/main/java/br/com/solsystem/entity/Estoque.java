package br.com.solsystem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estoques", uniqueConstraints = @UniqueConstraint(name = "uk_estoque_variacao", columnNames = "variacao_produto_id"))
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Estoque extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "variacao_produto_id", nullable = false)
    private VariacaoProduto variacao;

    @Column(name = "quantidade_atual", nullable = false)
    private Integer quantidadeAtual = 0;

    @Column(name = "estoque_minimo", nullable = false)
    private Integer estoqueMinimo = 0;

    /** TODO ETAPA 3: toda mudança de quantidade deve criar MovimentoEstoque na mesma transação. */
}
