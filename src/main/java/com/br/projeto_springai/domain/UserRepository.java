package com.br.projeto_springai.domain;

import com.br.projeto_springai.infra.entity.UserEntity;

public interface UserRepository {
    User save(User user);
}
