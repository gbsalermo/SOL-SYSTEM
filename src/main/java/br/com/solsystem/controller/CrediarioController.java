package br.com.solsystem.controller;

import br.com.solsystem.dto.request.RecebimentoRequest;
import br.com.solsystem.dto.response.ContaReceberResponse;
import br.com.solsystem.service.CrediarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/crediario")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMINISTRADOR','GERENTE','CAIXA')")
public class CrediarioController {
    private final CrediarioService service;

    @GetMapping("/contas") public List<ContaReceberResponse> listar() { return service.listar(); }
    @GetMapping("/contas/vencidas") public List<ContaReceberResponse> vencidas() { return service.listarVencidas(); }
    @GetMapping("/clientes/{clientePublicId}/contas") public List<ContaReceberResponse> porCliente(@PathVariable UUID clientePublicId) { return service.listarPorCliente(clientePublicId); }
    @PostMapping("/contas/{contaPublicId}/recebimentos") public ContaReceberResponse receber(@PathVariable UUID contaPublicId, @Valid @RequestBody RecebimentoRequest r) { return service.receber(contaPublicId, r); }
}
