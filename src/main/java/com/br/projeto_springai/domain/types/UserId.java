package com.br.projeto_springai.domain.types;

import java.util.Random;
import java.util.UUID;

public record UserId(UUID uuid) {
    public UserId() {
        this(UUID.randomUUID());
    }
}
