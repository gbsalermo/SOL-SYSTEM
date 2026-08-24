package br.com.solsystem.entity;

import br.com.solsystem.enums.ClassificacaoCliente;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cliente extends BaseEntity {

    @Column(nullable = false, length = 180)
    private String nome;

    @Column(length = 14, unique = true)
    private String cpf;

    @Column(length = 30)
    private String telefone;

    @Column(length = 180)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(length = 180)
    private String logradouro;

    @Column(length = 30)
    private String numero;

    @Column(length = 120)
    private String complemento;

    @Column(length = 120)
    private String bairro;

    @Column(length = 120)
    private String cidade;

    @Column(length = 2)
    private String estado;

    @Column(length = 9)
    private String cep;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ClassificacaoCliente classificacao = ClassificacaoCliente.PADRAO;

    @Column(name = "crediario_liberado", nullable = false)
    private boolean crediarioLiberado = false;

    @Column(name = "limite_credito", nullable = false, precision = 14, scale = 2)
    private BigDecimal limiteCredito = BigDecimal.ZERO;

    @Column(name = "motivo_classificacao", length = 1000)
    private String motivoClassificacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classificado_por_usuario_id")
    private Usuario classificadoPor;

    @Column(name = "classificado_em")
    private OffsetDateTime classificadoEm;

    @Column(length = 1000)
    private String observacoes;

    @Column(nullable = false)
    private boolean ativo = true;

    /**
     * TODO ETAPA 5/9:
     * - LISTA_VIP exige aprovação administrativa e libera crediário dentro do limite.
     * - LISTA_NEGRA bloqueia novas vendas a prazo.
     * - dívida NÃO deve ser um campo nesta entidade; derive de ContaReceber.
     */
}
