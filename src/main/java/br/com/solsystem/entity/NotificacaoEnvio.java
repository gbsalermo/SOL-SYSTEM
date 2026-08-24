package br.com.solsystem.entity;

import br.com.solsystem.enums.StatusNotificacao;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "notificacoes_envio")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificacaoEnvio extends BaseEntity {

    @Column(nullable = false, length = 60)
    private String tipo;

    @Column(nullable = false, length = 30)
    private String canal;

    @Column(length = 120)
    private String referencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusNotificacao status = StatusNotificacao.PENDENTE;

    @Column(nullable = false)
    private int tentativas = 0;

    @Column(name = "enviado_em")
    private OffsetDateTime enviadoEm;

    @Column(length = 2000)
    private String erro;
}
