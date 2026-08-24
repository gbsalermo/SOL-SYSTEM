package br.com.solsystem.controller;

import br.com.solsystem.dto.request.DespesaRequest;
import br.com.solsystem.dto.response.DespesaResponse;
import br.com.solsystem.service.DespesaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/despesas")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')")
public class DespesaController {
    private final DespesaService service;

    @PostMapping public ResponseEntity<DespesaResponse> registrar(@Valid @RequestBody DespesaRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(r)); }
    @GetMapping public List<DespesaResponse> listar() { return service.listar(); }
    @PostMapping("/{publicId}/cancelamento") public ResponseEntity<Void> cancelar(@PathVariable UUID publicId, @RequestParam UUID usuarioResponsavelPublicId) { service.cancelar(publicId, usuarioResponsavelPublicId); return ResponseEntity.noContent().build(); }
}
