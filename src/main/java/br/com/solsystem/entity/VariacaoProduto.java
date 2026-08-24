package br.com.solsystem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "variacoes_produto", uniqueConstraints = {
        @UniqueConstraint(name = "uk_variacao_sku", columnNames = "sku"),
        @UniqueConstraint(name = "uk_variacao_codigo_barras", columnNames = "codigo_barras")
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VariacaoProduto extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(length = 40)
    private String tamanho;

    @Column(length = 80)
    private String cor;

    @Column(nullable = false, length = 80)
    private String sku;

    @Column(name = "codigo_barras", length = 80)
    private String codigoBarras;

    @Column(name = "preco_venda", nullable = false, precision = 14, scale = 2)
    private BigDecimal precoVenda;

    /** TODO ETAPA 3/4: definir estratégia oficial de custo médio após cada entrada. */
    @Column(name = "custo_atual", nullable = false, precision = 14, scale = 2)
    private BigDecimal custoAtual;

    @Column(nullable = false)
    private boolean ativo = true;
}
