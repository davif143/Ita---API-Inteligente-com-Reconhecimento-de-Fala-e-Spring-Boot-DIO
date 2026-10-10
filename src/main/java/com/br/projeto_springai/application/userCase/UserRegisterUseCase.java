package com.br.projeto_springai.application.userCase;

import com.br.projeto_springai.application.input.UserRegisterInput;
import com.br.projeto_springai.application.output.UserRegisterOutput;
import com.br.projeto_springai.domain.User;
import com.br.projeto_springai.domain.UserRepository;
import com.br.projeto_springai.domain.types.UserId;
import com.br.projeto_springai.infra.security.TokenConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegisterUseCase {

    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserRegisterUseCase(AuthenticationManager authenticationManager, TokenConfig tokenConfig, PasswordEncoder passwordEncoder,
                               UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public UserRegisterOutput execute(UserRegisterInput userRegisterInput){
        String password = passwordEncoder.encode(userRegisterInput.password());
        var entity = userRepository.save(new User(
                userRegisterInput.nome(),
                userRegisterInput.email(),
                password
        ));
        return UserRegisterOutput.from(entity);
    }
}
