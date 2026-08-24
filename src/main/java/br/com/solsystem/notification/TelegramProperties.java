package br.com.solsystem.notification;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.telegram")
public record TelegramProperties(
        boolean enabled,
        String botToken,
        String chatId,
        String dailyReportCron
) {
}
