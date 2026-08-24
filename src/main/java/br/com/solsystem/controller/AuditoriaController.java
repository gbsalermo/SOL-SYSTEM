package br.com.solsystem.controller;

import br.com.solsystem.audit.AuditoriaService;
import br.com.solsystem.dto.response.AuditoriaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/auditoria")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class AuditoriaController {
    private final AuditoriaService service;

    @GetMapping
    public List<AuditoriaResponse> buscar(@RequestParam String entidade, @RequestParam UUID publicIdEntidade) {
        return service.buscar(entidade, publicIdEntidade);
    }
}
