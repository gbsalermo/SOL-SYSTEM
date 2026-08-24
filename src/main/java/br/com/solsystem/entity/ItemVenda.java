package br.com.solsystem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_venda")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemVenda extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "variacao_produto_id", nullable = false)
    private VariacaoProduto variacao;

    @Column(nullable = false)
    private Integer quantidade;

    /** Snapshot financeiro: não recalcular uma venda antiga usando preço/custo atual. */
    @Column(name = "preco_unitario", nullable = false, precision = 14, scale = 2)
    private BigDecimal precoUnitario;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal desconto = BigDecimal.ZERO;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "custo_unitario", nullable = false, precision = 14, scale = 2)
    private BigDecimal custoUnitario;

    @Column(name = "custo_total", nullable = false, precision = 14, scale = 2)
    private BigDecimal custoTotal;

    @Column(name = "lucro_bruto", nullable = false, precision = 14, scale = 2)
    private BigDecimal lucroBruto;
}
