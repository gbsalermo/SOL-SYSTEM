package br.com.solsystem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "cancelamentos_venda")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CancelamentoVenda extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venda_id", nullable = false, unique = true)
    private Venda venda;

    @Column(nullable = false, length = 1000)
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_responsavel_id", nullable = false)
    private Usuario usuarioResponsavel;

    @Column(name = "cancelado_em", nullable = false)
    private OffsetDateTime canceladoEm;

    @Column(name = "valor_estornado", nullable = false, precision = 14, scale = 2)
    private BigDecimal valorEstornado;

    /** TODO ETAPA 10: cancelamento coordena estoque + pagamentos + caixa + crediário numa única transação. */
}
