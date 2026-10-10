package com.br.projeto_springai.infra.persistence.repository;

import com.br.projeto_springai.domain.Category;
import com.br.projeto_springai.infra.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findAllByCategory(Category category);
}
