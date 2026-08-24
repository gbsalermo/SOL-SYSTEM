package br.com.solsystem.security;

import br.com.solsystem.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String gerarToken(Usuario usuario) {
        throw new UnsupportedOperationException("TODO ETAPA 1.5: implementar geração JWT sem expor dados sensíveis");
    }

    public boolean tokenValido(String token) {
        throw new UnsupportedOperationException("TODO ETAPA 1.5: implementar validação JWT");
    }
}
