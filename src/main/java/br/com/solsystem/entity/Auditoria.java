package br.com.solsystem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "auditorias")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auditoria extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(nullable = false, length = 100)
    private String acao;

    @Column(nullable = false, length = 100)
    private String entidade;

    @Column(name = "public_id_entidade")
    private UUID publicIdEntidade;

    @Lob
    private String detalhes;

    @Column(length = 80)
    private String ip;

    @Column(name = "correlation_id", length = 100)
    private String correlationId;

    /** TODO ETAPA 12: nunca registrar senha, token, CPF completo ou outros segredos no campo detalhes. */
}
