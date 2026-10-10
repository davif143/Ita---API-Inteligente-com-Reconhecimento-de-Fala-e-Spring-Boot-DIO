package com.br.projeto_springai.infra.persistence.repository;

import com.br.projeto_springai.domain.Category;
import com.br.projeto_springai.domain.Transaction;
import com.br.projeto_springai.domain.TransactionRepository;
import com.br.projeto_springai.infra.entity.TransactionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPATransactionRepository implements TransactionRepository {
    private final TransactionEntityRepository transactionEntityRepository;

    public JPATransactionRepository(TransactionEntityRepository transactionEntityRepository) {
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        var entity = TransactionEntity.from(transaction);
        return transactionEntityRepository.save(entity).toDomain();
    }

    @Override
    public List<Transaction> findAllByCategory(Category category) {
        return transactionEntityRepository.findAllByCategory(category)
                .stream()
                .map(TransactionEntity::toDomain)
                .toList();
    }
}
