package br.com.solsystem.controller;

import br.com.solsystem.dto.request.UsuarioRequest;
import br.com.solsystem.dto.response.UsuarioResponse;
import br.com.solsystem.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping public ResponseEntity<UsuarioResponse> criar(@Valid @RequestBody UsuarioRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(r)); }
    @GetMapping public List<UsuarioResponse> listar() { return service.listar(); }
    @GetMapping("/{publicId}") public UsuarioResponse buscar(@PathVariable UUID publicId) { return service.buscar(publicId); }
    @PutMapping("/{publicId}") public UsuarioResponse atualizar(@PathVariable UUID publicId, @Valid @RequestBody UsuarioRequest r) { return service.atualizar(publicId, r); }
    @PatchMapping("/{publicId}/desativar") public ResponseEntity<Void> desativar(@PathVariable UUID publicId) { service.desativar(publicId); return ResponseEntity.noContent().build(); }
}
