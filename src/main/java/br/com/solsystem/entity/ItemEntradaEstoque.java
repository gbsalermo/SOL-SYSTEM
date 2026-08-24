package br.com.solsystem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_entrada_estoque")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemEntradaEstoque extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entrada_id", nullable = false)
    private EntradaEstoque entrada;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "variacao_produto_id", nullable = false)
    private VariacaoProduto variacao;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "custo_unitario", nullable = false, precision = 14, scale = 2)
    private BigDecimal custoUnitario;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal subtotal;
}
