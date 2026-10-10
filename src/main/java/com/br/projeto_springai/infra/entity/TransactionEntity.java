package com.br.projeto_springai.infra.entity;

import com.br.projeto_springai.domain.Category;
import com.br.projeto_springai.domain.Transaction;
import com.br.projeto_springai.domain.types.TransactionId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    private UUID id;
    private String description;
    private long amount;
    private Category category;

    public static TransactionEntity from(Transaction transaction){
        return new TransactionEntity(
                transaction.getId().uuid(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getCategory()
        );
    }

    public Transaction toDomain() {
        return new Transaction(
                new TransactionId(this.id),
                this.description,
                this.amount,
                this.category
        );
    }
}
