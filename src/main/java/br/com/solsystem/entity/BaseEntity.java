package br.com.solsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

/**
 * Fundação obrigatória de persistência.
 *
 * Já implementado para impedir exposição acidental do ID interno e padronizar publicId.
 * Nas entidades concretas, a API deve trafegar somente publicId.
 */
@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "public_id", nullable = false, unique = true, updatable = false)
    private UUID publicId;

    @Version
    @JsonIgnore
    private Long version;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private OffsetDateTime criadoEm;

    @Column(name = "atualizado_em", nullable = false)
    private OffsetDateTime atualizadoEm;

    @PrePersist
    protected void prePersist() {
        if (publicId == null) {
            publicId = UUID.randomUUID();
        }
        OffsetDateTime agora = OffsetDateTime.now(ZoneOffset.UTC);
        criadoEm = agora;
        atualizadoEm = agora;
    }

    @PreUpdate
    protected void preUpdate() {
        atualizadoEm = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
