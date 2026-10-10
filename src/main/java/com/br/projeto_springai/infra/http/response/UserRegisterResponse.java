package com.br.projeto_springai.infra.http.response;

import com.br.projeto_springai.application.output.UserRegisterOutput;

public record UserRegisterResponse(String id, String nome, String email) {
    public static UserRegisterResponse from(UserRegisterOutput output){
        return new UserRegisterResponse(
                output.id(),
                output.nome(),
                output.email()
        );
    }
}
