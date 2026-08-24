package br.com.solsystem.controller;

import br.com.solsystem.dto.request.AjusteEstoqueRequest;
import br.com.solsystem.dto.response.EstoqueResponse;
import br.com.solsystem.service.EstoqueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/estoque")
@RequiredArgsConstructor
public class EstoqueController {
    private final EstoqueService service;

    @GetMapping public List<EstoqueResponse> listar() { return service.listar(); }
    @GetMapping("/variacao/{publicId}") public EstoqueResponse buscar(@PathVariable UUID publicId) { return service.buscarPorVariacao(publicId); }
    @PostMapping("/ajustes") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','ESTOQUE')") public EstoqueResponse ajustar(@Valid @RequestBody AjusteEstoqueRequest r) { return service.ajustar(r); }
}
