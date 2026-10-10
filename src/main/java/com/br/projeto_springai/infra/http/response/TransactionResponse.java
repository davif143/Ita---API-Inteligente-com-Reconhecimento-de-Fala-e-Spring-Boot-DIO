package com.br.projeto_springai.infra.http.response;

import com.br.projeto_springai.application.output.TransactionOutput;

public record TransactionResponse(String id, String category, double amount) {
    public static TransactionResponse from(TransactionOutput output){
        return new TransactionResponse(output.id(), output.category(), output.value());
    }
}
