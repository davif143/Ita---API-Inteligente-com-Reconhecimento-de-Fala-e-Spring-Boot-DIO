package com.br.projeto_springai.infra.http.request;

import com.br.projeto_springai.application.input.UserLoginInput;
import com.br.projeto_springai.application.input.UserRegisterInput;

public record UserRegisterRequest(String nome, String email, String password) {
    public UserRegisterInput toInput(){
        return new UserRegisterInput(nome, email, password);
    }
}