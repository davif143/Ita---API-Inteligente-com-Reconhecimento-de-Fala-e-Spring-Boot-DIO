package com.br.projeto_springai.infra.http.request;

import com.br.projeto_springai.application.input.UserLoginInput;

public record UserLoginRequest(String email, String password) {
    public UserLoginInput toInput(){
        return new UserLoginInput(email, password);
    }
}
