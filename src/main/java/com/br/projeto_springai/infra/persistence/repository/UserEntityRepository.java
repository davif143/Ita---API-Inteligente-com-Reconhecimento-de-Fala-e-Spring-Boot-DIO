package com.br.projeto_springai.infra.persistence.repository;

import com.br.projeto_springai.infra.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserEntityRepository extends CrudRepository<UserEntity, UUID> {
    Optional<UserDetails> findUserByEmail(String email);
}
