package br.com.solsystem.notification;

import br.com.solsystem.dto.response.RelatorioDiarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelegramService {

    private final TelegramProperties properties;

    public void enviarRelatorioDiario(RelatorioDiarioResponse relatorio) {
        if (!properties.enabled()) {
            return;
        }
        throw new UnsupportedOperationException("TODO ETAPA 14: formatar relatório e enviar pela Telegram Bot API; token somente via ambiente");
    }
}
