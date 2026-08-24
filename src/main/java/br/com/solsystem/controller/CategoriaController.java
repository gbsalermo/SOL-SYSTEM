package br.com.solsystem.controller;

import br.com.solsystem.dto.request.CategoriaRequest;
import br.com.solsystem.dto.response.CategoriaResponse;
import br.com.solsystem.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService service;

    @GetMapping public List<CategoriaResponse> listar() { return service.listar(); }
    @GetMapping("/{publicId}") public CategoriaResponse buscar(@PathVariable UUID publicId) { return service.buscar(publicId); }
    @PostMapping @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','ESTOQUE')") public ResponseEntity<CategoriaResponse> criar(@Valid @RequestBody CategoriaRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(r)); }
    @PutMapping("/{publicId}") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','ESTOQUE')") public CategoriaResponse atualizar(@PathVariable UUID publicId, @Valid @RequestBody CategoriaRequest r) { return service.atualizar(publicId, r); }
    @PatchMapping("/{publicId}/desativar") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')") public ResponseEntity<Void> desativar(@PathVariable UUID publicId) { service.desativar(publicId); return ResponseEntity.noContent().build(); }
}
