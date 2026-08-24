package br.com.solsystem.dto.response;

public record AuthResponse(
        String accessToken,
        String tokenType,
        long expiresInSeconds
) {
}
