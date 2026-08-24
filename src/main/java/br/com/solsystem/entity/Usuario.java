package br.com.solsystem.entity;

import br.com.solsystem.enums.PerfilAcesso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(name = "uk_usuario_login", columnNames = "login"))
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Usuario extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "funcionario_id", nullable = false, unique = true)
    private Funcionario funcionario;

    @Column(nullable = false, length = 180)
    private String login;

    /** Nunca retornar em DTO/JSON/log. Armazenar exclusivamente hash BCrypt (ou sucessor aprovado). */
    @JsonIgnore
    @Column(name = "senha_hash", nullable = false, length = 255)
    private String senhaHash;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "usuario_perfis", joinColumns = @JoinColumn(name = "usuario_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false, length = 40)
    private Set<PerfilAcesso> perfis = new HashSet<>();

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(name = "troca_senha_obrigatoria", nullable = false)
    private boolean trocaSenhaObrigatoria = true;

    @Column(name = "ultimo_login_em")
    private OffsetDateTime ultimoLoginEm;

    @Column(name = "tentativas_falhas", nullable = false)
    private int tentativasFalhas = 0;

    @Column(name = "bloqueado_ate")
    private OffsetDateTime bloqueadoAte;

    /** TODO ETAPA 1: implementar criação/troca de senha via service usando PasswordEncoder. */
}
