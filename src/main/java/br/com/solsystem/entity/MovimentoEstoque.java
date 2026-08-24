package br.com.solsystem.entity;

import br.com.solsystem.enums.TipoMovimentoEstoque;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movimentos_estoque")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovimentoEstoque extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "variacao_produto_id", nullable = false)
    private VariacaoProduto variacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private TipoMovimentoEstoque tipo;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "quantidade_anterior", nullable = false)
    private Integer quantidadeAnterior;

    @Column(name = "quantidade_posterior", nullable = false)
    private Integer quantidadePosterior;

    @Column(nullable = false, length = 500)
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_responsavel_id", nullable = false)
    private Usuario usuarioResponsavel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrada_estoque_id")
    private EntradaEstoque entrada;
}
