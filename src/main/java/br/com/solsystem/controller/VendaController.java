package br.com.solsystem.controller;

import br.com.solsystem.dto.request.CancelamentoVendaRequest;
import br.com.solsystem.dto.request.VendaRequest;
import br.com.solsystem.dto.response.VendaResponse;
import br.com.solsystem.service.VendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/vendas")
@RequiredArgsConstructor
public class VendaController {
    private final VendaService service;

    @PostMapping @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','CAIXA','VENDEDOR')") public ResponseEntity<VendaResponse> realizar(@Valid @RequestBody VendaRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.realizar(r)); }
    @GetMapping public List<VendaResponse> listar() { return service.listar(); }
    @GetMapping("/{publicId}") public VendaResponse buscar(@PathVariable UUID publicId) { return service.buscar(publicId); }
    @PostMapping("/{publicId}/cancelamento") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')") public VendaResponse cancelar(@PathVariable UUID publicId, @Valid @RequestBody CancelamentoVendaRequest r) { return service.cancelar(publicId, r); }
}
