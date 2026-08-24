package br.com.solsystem.controller;

import br.com.solsystem.dto.request.ProdutoRequest;
import br.com.solsystem.dto.request.VariacaoProdutoRequest;
import br.com.solsystem.dto.response.ProdutoResponse;
import br.com.solsystem.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService service;

    @GetMapping public List<ProdutoResponse> listar() { return service.listar(); }
    @GetMapping("/variacoes/{publicId}") public ProdutoResponse buscarVariacao(@PathVariable UUID publicId) { return service.buscarVariacao(publicId); }
    @GetMapping("/codigo-barras/{codigo}") public ProdutoResponse buscarCodigo(@PathVariable String codigo) { return service.buscarPorCodigoBarras(codigo); }
    @PostMapping @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','ESTOQUE')") public ResponseEntity<ProdutoResponse> criar(@Valid @RequestBody ProdutoRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(r)); }
    @PostMapping("/{publicId}/variacoes") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','ESTOQUE')") public ResponseEntity<ProdutoResponse> adicionarVariacao(@PathVariable UUID publicId, @Valid @RequestBody VariacaoProdutoRequest r) { return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarVariacao(publicId, r)); }
    @PutMapping("/{publicId}") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','ESTOQUE')") public ProdutoResponse atualizar(@PathVariable UUID publicId, @Valid @RequestBody ProdutoRequest r) { return service.atualizar(publicId, r); }
    @PatchMapping("/{publicId}/desativar") @PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE')") public ResponseEntity<Void> desativar(@PathVariable UUID publicId) { service.desativar(publicId); return ResponseEntity.noContent().build(); }
}
