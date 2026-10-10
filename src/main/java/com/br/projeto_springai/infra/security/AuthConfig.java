package com.br.projeto_springai.infra.security;

import com.br.projeto_springai.infra.persistence.repository.UserEntityRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthConfig implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    public AuthConfig(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userEntityRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
