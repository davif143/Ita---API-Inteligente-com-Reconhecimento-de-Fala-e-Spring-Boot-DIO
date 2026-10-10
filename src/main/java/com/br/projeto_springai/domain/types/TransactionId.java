package com.br.projeto_springai.domain.types;

import java.util.UUID;

public record TransactionId(
        UUID uuid
) {
    public TransactionId(){
        this(UUID.randomUUID());
    }
}
