package br.com.solsystem.controller;

import br.com.solsystem.dto.request.FuncionarioRequest;
import br.com.solsystem.dto.response.FuncionarioResponse;
import br.com.solsystem.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/funcionarios")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')")
public class FuncionarioController {
    private final FuncionarioService service;

    @PostMapping public ResponseEntity<FuncionarioResponse> criar(@Valid @RequestBody FuncionarioRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(r)); }
    @GetMapping public List<FuncionarioResponse> listar() { return service.listar(); }
    @GetMapping("/{publicId}") public FuncionarioResponse buscar(@PathVariable UUID publicId) { return service.buscar(publicId); }
    @PutMapping("/{publicId}") public FuncionarioResponse atualizar(@PathVariable UUID publicId, @Valid @RequestBody FuncionarioRequest r) { return service.atualizar(publicId, r); }
    @PatchMapping("/{publicId}/desativar") public ResponseEntity<Void> desativar(@PathVariable UUID publicId) { service.desativar(publicId); return ResponseEntity.noContent().build(); }
}
