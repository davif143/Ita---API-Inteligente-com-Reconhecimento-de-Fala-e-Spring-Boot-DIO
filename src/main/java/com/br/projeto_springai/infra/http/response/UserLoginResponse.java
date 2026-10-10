package com.br.projeto_springai.infra.http.response;

import com.br.projeto_springai.application.output.UserLoginOutput;

public record UserLoginResponse (String token){
    public static UserLoginResponse from(UserLoginOutput output){
        return new UserLoginResponse(output.token());
    }
}
