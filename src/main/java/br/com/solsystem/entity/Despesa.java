package br.com.solsystem.entity;

import br.com.solsystem.enums.FormaPagamento;
import br.com.solsystem.enums.StatusDespesa;
import br.com.solsystem.enums.TipoDespesa;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "despesas")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Despesa extends BaseEntity {

    @Column(nullable = false, length = 300)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoDespesa tipo;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false, length = 30)
    private FormaPagamento formaPagamento;

    @Column(name = "data_despesa", nullable = false)
    private OffsetDateTime dataDespesa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_responsavel_id", nullable = false)
    private Usuario usuarioResponsavel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sessao_caixa_id")
    private SessaoCaixa sessaoCaixa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusDespesa status = StatusDespesa.REGISTRADA;

    @Column(length = 1000)
    private String observacao;
}
