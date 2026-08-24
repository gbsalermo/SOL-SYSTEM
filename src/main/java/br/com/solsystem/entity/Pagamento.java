package br.com.solsystem.entity;

import br.com.solsystem.enums.FormaPagamento;
import br.com.solsystem.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pagamento extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false, length = 30)
    private FormaPagamento formaPagamento;

    @Column(nullable = false, precision = 14, scale = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusPagamento status = StatusPagamento.PENDENTE;

    @Column(name = "data_pagamento")
    private OffsetDateTime dataPagamento;
}
