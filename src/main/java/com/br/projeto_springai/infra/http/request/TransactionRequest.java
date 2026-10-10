package com.br.projeto_springai.infra.http.request;

import com.br.projeto_springai.application.input.TransactionPersistInput;
import com.br.projeto_springai.domain.Category;

public record TransactionRequest(String description, Category category, long amount) {
    public TransactionPersistInput toInput() {
        return new TransactionPersistInput(description, amount, category);
    }
}
