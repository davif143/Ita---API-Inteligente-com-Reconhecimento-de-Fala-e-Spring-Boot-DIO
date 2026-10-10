package com.br.projeto_springai.infra.persistence.repository;

import com.br.projeto_springai.domain.User;
import com.br.projeto_springai.domain.UserRepository;
import com.br.projeto_springai.infra.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class JPAUserRepository implements UserRepository {
    private final UserEntityRepository userEntityRepository;

    public JPAUserRepository(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public User save(User user) {
        var entity = UserEntity.from(user);
        return userEntityRepository.save(entity).toDomain();
    }
}
