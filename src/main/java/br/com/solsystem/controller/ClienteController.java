package br.com.solsystem.controller;

import br.com.solsystem.dto.request.ClassificarClienteRequest;
import br.com.solsystem.dto.request.ClienteRequest;
import br.com.solsystem.dto.response.ClienteResponse;
import br.com.solsystem.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','CAIXA','VENDEDOR')") public ResponseEntity<ClienteResponse> criar(@Valid @RequestBody ClienteRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(r)); }
    @GetMapping public List<ClienteResponse> listar() { return service.listar(); }
    @GetMapping("/{publicId}") public ClienteResponse buscar(@PathVariable UUID publicId) { return service.buscar(publicId); }
    @PutMapping("/{publicId}") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','CAIXA')") public ClienteResponse atualizar(@PathVariable UUID publicId, @Valid @RequestBody ClienteRequest r) { return service.atualizar(publicId, r); }
    @PatchMapping("/{publicId}/classificacao") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')") public ClienteResponse classificar(@PathVariable UUID publicId, @Valid @RequestBody ClassificarClienteRequest r) { return service.classificar(publicId, r); }
    @PatchMapping("/{publicId}/desativar") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')") public ResponseEntity<Void> desativar(@PathVariable UUID publicId) { service.desativar(publicId); return ResponseEntity.noContent().build(); }
}
