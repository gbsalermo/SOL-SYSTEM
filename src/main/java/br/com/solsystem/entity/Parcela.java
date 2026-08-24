package br.com.solsystem.entity;

import br.com.solsystem.enums.StatusParcela;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "parcelas")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Parcela extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conta_receber_id", nullable = false)
    private ContaReceber contaReceber;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal valor;

    @Column(name = "valor_pago", nullable = false, precision = 14, scale = 2)
    private BigDecimal valorPago = BigDecimal.ZERO;

    @Column(nullable = false)
    private LocalDate vencimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusParcela status = StatusParcela.PENDENTE;
}
