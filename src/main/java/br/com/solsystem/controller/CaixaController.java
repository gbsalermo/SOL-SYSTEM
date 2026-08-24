package br.com.solsystem.controller;

import br.com.solsystem.dto.request.*;
import br.com.solsystem.dto.response.CaixaResponse;
import br.com.solsystem.service.CaixaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/caixas")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','CAIXA')")
public class CaixaController {
    private final CaixaService service;

    @PostMapping @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')") public ResponseEntity<CaixaResponse> criar(@Valid @RequestBody CaixaRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.criarCaixa(r)); }
    @PostMapping("/{caixaPublicId}/abrir") public CaixaResponse abrir(@PathVariable UUID caixaPublicId, @Valid @RequestBody AbrirCaixaRequest r) { return service.abrir(caixaPublicId, r); }
    @PostMapping("/sessoes/{sessaoPublicId}/fechar") public CaixaResponse fechar(@PathVariable UUID sessaoPublicId, @Valid @RequestBody FecharCaixaRequest r) { return service.fechar(sessaoPublicId, r); }
    @PostMapping("/sessoes/{sessaoPublicId}/sangrias") public ResponseEntity<Void> sangria(@PathVariable UUID sessaoPublicId, @Valid @RequestBody MovimentoCaixaRequest r) { service.sangria(sessaoPublicId, r); return ResponseEntity.noContent().build(); }
    @PostMapping("/sessoes/{sessaoPublicId}/suprimentos") public ResponseEntity<Void> suprimento(@PathVariable UUID sessaoPublicId, @Valid @RequestBody MovimentoCaixaRequest r) { service.suprimento(sessaoPublicId, r); return ResponseEntity.noContent().build(); }
    @GetMapping("/sessoes") public List<CaixaResponse> listarSessoes() { return service.listarSessoes(); }
}
