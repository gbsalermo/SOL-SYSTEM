package br.com.solsystem.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /**
     * TODO ETAPA 1.5:
     * 1. Extrair Authorization: Bearer <token>.
     * 2. Validar assinatura/expiração no JwtService.
     * 3. Carregar Usuario pelo subject/publicId.
     * 4. Construir Authentication com roles/permissões.
     * 5. Nunca logar o token.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }
}
