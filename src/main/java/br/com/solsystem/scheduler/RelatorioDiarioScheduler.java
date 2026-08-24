package br.com.solsystem.scheduler;

import br.com.solsystem.notification.TelegramProperties;
import br.com.solsystem.notification.TelegramService;
import br.com.solsystem.report.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class RelatorioDiarioScheduler {
    private final RelatorioService relatorioService;
    private final TelegramService telegramService;
    private final TelegramProperties properties;
    private final Clock clock;

    @Scheduled(cron = "${app.telegram.daily-report-cron}", zone = "${app.zone-id}")
    public void enviarResumoDiario() {
        if (!properties.enabled()) return;
        var relatorio = relatorioService.gerarDiario(LocalDate.now(clock));
        telegramService.enviarRelatorioDiario(relatorio);
    }
}
