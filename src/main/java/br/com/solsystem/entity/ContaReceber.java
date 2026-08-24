package br.com.solsystem.entity;

import br.com.solsystem.enums.StatusContaReceber;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contas_receber")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContaReceber extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venda_id", nullable = false, unique = true)
    private Venda venda;

    @Column(name = "valor_original", nullable = false, precision = 14, scale = 2)
    private BigDecimal valorOriginal;

    @Column(name = "valor_pago", nullable = false, precision = 14, scale = 2)
    private BigDecimal valorPago = BigDecimal.ZERO;

    @Column(name = "saldo_devedor", nullable = false, precision = 14, scale = 2)
    private BigDecimal saldoDevedor;

    @Column(nullable = false)
    private LocalDate vencimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusContaReceber status = StatusContaReceber.ABERTA;

    @Column(length = 1000)
    private String observacao;

    @OneToMany(mappedBy = "contaReceber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parcela> parcelas = new ArrayList<>();

    /** TODO ETAPA 9: saldo é alterado somente por Recebimento/estorno; nunca editar manualmente. */
}
