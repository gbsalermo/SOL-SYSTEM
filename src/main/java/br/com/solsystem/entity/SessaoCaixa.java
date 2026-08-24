package br.com.solsystem.entity;

import br.com.solsystem.enums.StatusCaixa;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "sessoes_caixa")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SessaoCaixa extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "caixa_id", nullable = false)
    private Caixa caixa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "funcionario_abertura_id", nullable = false)
    private Funcionario funcionarioAbertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_fechamento_id")
    private Funcionario funcionarioFechamento;

    @Column(name = "abertura_em", nullable = false)
    private OffsetDateTime aberturaEm;

    @Column(name = "fechamento_em")
    private OffsetDateTime fechamentoEm;

    @Column(name = "valor_inicial", nullable = false, precision = 14, scale = 2)
    private BigDecimal valorInicial;

    @Column(name = "valor_esperado", precision = 14, scale = 2)
    private BigDecimal valorEsperado;

    @Column(name = "valor_contado", precision = 14, scale = 2)
    private BigDecimal valorContado;

    @Column(precision = 14, scale = 2)
    private BigDecimal diferenca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusCaixa status = StatusCaixa.ABERTO;

    /** TODO ETAPA 8: impedir mais de uma sessão aberta por caixa. */
}
