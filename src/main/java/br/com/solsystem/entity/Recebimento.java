package br.com.solsystem.entity;

import br.com.solsystem.enums.FormaPagamento;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "recebimentos")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recebimento extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conta_receber_id", nullable = false)
    private ContaReceber contaReceber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcela_id")
    private Parcela parcela;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false, length = 30)
    private FormaPagamento formaPagamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_responsavel_id", nullable = false)
    private Usuario usuarioResponsavel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sessao_caixa_id", nullable = false)
    private SessaoCaixa sessaoCaixa;

    @Column(name = "recebido_em", nullable = false)
    private OffsetDateTime recebidoEm;

    @Column(length = 1000)
    private String observacao;
}
