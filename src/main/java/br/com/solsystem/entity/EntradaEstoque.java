package br.com.solsystem.entity;

import br.com.solsystem.enums.StatusEntradaEstoque;
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
@Table(name = "entradas_estoque")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EntradaEstoque extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @Column(name = "numero_documento", length = 100)
    private String numeroDocumento;

    @Column(name = "data_entrada", nullable = false)
    private OffsetDateTime dataEntrada;

    @Column(name = "custo_total", nullable = false, precision = 14, scale = 2)
    private BigDecimal custoTotal;

    @Column(length = 1000)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_responsavel_id", nullable = false)
    private Usuario usuarioResponsavel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusEntradaEstoque status = StatusEntradaEstoque.RASCUNHO;

    @OneToMany(mappedBy = "entrada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntradaEstoque> itens = new ArrayList<>();

    /** TODO ETAPA 4: receber entrada deve atualizar estoque/custo e criar movimentos atomicamente. */
}
