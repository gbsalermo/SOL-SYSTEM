package br.com.solsystem.controller;

import br.com.solsystem.dto.response.RelatorioDiarioResponse;
import br.com.solsystem.notification.TelegramService;
import br.com.solsystem.report.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/relatorios")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')")
public class RelatorioController {
    private final RelatorioService relatorioService;
    private final TelegramService telegramService;

    @GetMapping("/diario")
    public RelatorioDiarioResponse diario(@RequestParam LocalDate data) {
        return relatorioService.gerarDiario(data);
    }

    @PostMapping("/diario/enviar-telegram")
    public RelatorioDiarioResponse enviarTelegram(@RequestParam LocalDate data) {
        var relatorio = relatorioService.gerarDiario(data);
        telegramService.enviarRelatorioDiario(relatorio);
        return relatorio;
    }
}
