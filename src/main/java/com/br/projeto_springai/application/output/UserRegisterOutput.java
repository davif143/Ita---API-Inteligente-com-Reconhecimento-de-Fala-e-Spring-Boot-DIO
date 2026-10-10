package com.br.projeto_springai.application.output;

import com.br.projeto_springai.domain.User;

import java.util.UUID;

public record UserRegisterOutput(String id, String nome, String email) {
    public static UserRegisterOutput from(User user){
        return new UserRegisterOutput(
                user.getUserId().uuid().toString(),
                user.getName(),
                user.getEmail()
        );
    }
}
