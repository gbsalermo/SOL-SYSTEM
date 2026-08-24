package br.com.solsystem.entity;

import br.com.solsystem.enums.TipoMovimentoCaixa;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "movimentos_caixa")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovimentoCaixa extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sessao_caixa_id", nullable = false)
    private SessaoCaixa sessaoCaixa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private TipoMovimentoCaixa tipo;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false, length = 500)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recebimento_id")
    private Recebimento recebimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "despesa_id")
    private Despesa despesa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_responsavel_id", nullable = false)
    private Usuario usuarioResponsavel;

    /** TODO ETAPA 8: movimento é histórico imutável; correção gera novo movimento, não UPDATE destrutivo. */
}
