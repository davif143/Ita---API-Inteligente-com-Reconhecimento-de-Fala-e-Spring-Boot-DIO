package com.br.projeto_springai.application.userCase;

import com.br.projeto_springai.application.input.UserLoginInput;
import com.br.projeto_springai.application.output.UserLoginOutput;
import com.br.projeto_springai.domain.User;
import com.br.projeto_springai.infra.security.TokenConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserLoginUseCase {

    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public UserLoginUseCase(AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    public UserLoginOutput execute(UserLoginInput userLoginInput){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(
                userLoginInput.email(),userLoginInput.password()
        );
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return new UserLoginOutput(token);
    }

}
