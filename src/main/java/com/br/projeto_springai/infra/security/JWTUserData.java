package com.br.projeto_springai.infra.security;

import lombok.Builder;

@Builder
public record JWTUserData(
        Long id,
        String email
) {
}