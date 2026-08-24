package br.com.solsystem.controller;

import br.com.solsystem.dto.request.FornecedorRequest;
import br.com.solsystem.dto.response.FornecedorResponse;
import br.com.solsystem.service.FornecedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/fornecedores")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','ESTOQUE')")
public class FornecedorController {
    private final FornecedorService service;

    @PostMapping public ResponseEntity<FornecedorResponse> criar(@Valid @RequestBody FornecedorRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(r)); }
    @GetMapping public List<FornecedorResponse> listar() { return service.listar(); }
    @GetMapping("/{publicId}") public FornecedorResponse buscar(@PathVariable UUID publicId) { return service.buscar(publicId); }
    @PutMapping("/{publicId}") public FornecedorResponse atualizar(@PathVariable UUID publicId, @Valid @RequestBody FornecedorRequest r) { return service.atualizar(publicId, r); }
    @PatchMapping("/{publicId}/desativar") public ResponseEntity<Void> desativar(@PathVariable UUID publicId) { service.desativar(publicId); return ResponseEntity.noContent().build(); }
}
