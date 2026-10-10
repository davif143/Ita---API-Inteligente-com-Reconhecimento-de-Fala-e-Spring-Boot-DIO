package com.br.projeto_springai.infra.http;

import com.br.projeto_springai.application.input.UserRegisterInput;
import com.br.projeto_springai.application.userCase.UserLoginUseCase;
import com.br.projeto_springai.application.userCase.UserRegisterUseCase;
import com.br.projeto_springai.infra.http.request.UserLoginRequest;
import com.br.projeto_springai.infra.http.request.UserRegisterRequest;
import com.br.projeto_springai.infra.http.response.UserLoginResponse;
import com.br.projeto_springai.infra.http.response.UserRegisterResponse;
import com.br.projeto_springai.infra.persistence.repository.UserEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRegisterUseCase userRegisterUseCase;
    private final UserLoginUseCase userLoginUseCase;

    public AuthController(UserRegisterUseCase userRegisterUseCase, UserLoginUseCase userLoginUseCase) {
        this.userRegisterUseCase = userRegisterUseCase;
        this.userLoginUseCase = userLoginUseCase;
    }

    @PostMapping("/register")
    public UserRegisterResponse register(UserRegisterRequest request){
        var entity = userRegisterUseCase.execute(request.toInput());
        return UserRegisterResponse.from(entity);
    }

    @PostMapping("/login")
    public UserLoginResponse login(UserLoginRequest request){
        var entity = userLoginUseCase.execute(request.toInput());
        return UserLoginResponse.from(entity);
    }
}
