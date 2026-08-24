package br.com.solsystem.entity;

import br.com.solsystem.enums.StatusVenda;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendas", uniqueConstraints = @UniqueConstraint(name = "uk_venda_numero", columnNames = "numero_venda"))
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Venda extends BaseEntity {

    @Column(name = "numero_venda", nullable = false, length = 50)
    private String numeroVenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "funcionario_vendedor_id", nullable = false)
    private Funcionario funcionarioVendedor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sessao_caixa_id", nullable = false)
    private SessaoCaixa sessaoCaixa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusVenda status = StatusVenda.ABERTA;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal subtotal = BigDecimal.ZERO;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal desconto = BigDecimal.ZERO;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "custo_total", nullable = false, precision = 14, scale = 2)
    private BigDecimal custoTotal = BigDecimal.ZERO;

    @Column(name = "lucro_bruto", nullable = false, precision = 14, scale = 2)
    private BigDecimal lucroBruto = BigDecimal.ZERO;

    @Column(length = 1000)
    private String observacao;

    @Column(name = "finalizada_em")
    private OffsetDateTime finalizadaEm;

    @Column(name = "cancelada_em")
    private OffsetDateTime canceladaEm;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens = new ArrayList<>();

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<>();

    /** TODO ETAPA 6: finalização é transação única; venda finalizada nunca é apagada/editada como fato histórico. */
}
