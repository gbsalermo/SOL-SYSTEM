package br.com.solsystem.controller;

import br.com.solsystem.dto.request.EntradaEstoqueRequest;
import br.com.solsystem.dto.response.EntradaEstoqueResponse;
import br.com.solsystem.service.EntradaEstoqueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/entradas-estoque")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','ESTOQUE')")
public class EntradaEstoqueController {
    private final EntradaEstoqueService service;

    @PostMapping public ResponseEntity<EntradaEstoqueResponse> registrar(@Valid @RequestBody EntradaEstoqueRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(r)); }
    @GetMapping public List<EntradaEstoqueResponse> listar() { return service.listar(); }
    @GetMapping("/{publicId}") public EntradaEstoqueResponse buscar(@PathVariable UUID publicId) { return service.buscar(publicId); }
}
