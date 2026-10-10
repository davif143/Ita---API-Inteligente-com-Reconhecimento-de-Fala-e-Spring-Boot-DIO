package com.br.projeto_springai.application.userCase;

import com.br.projeto_springai.application.input.TransactionPersistInput;
import com.br.projeto_springai.application.output.TransactionOutput;
import com.br.projeto_springai.domain.Transaction;
import com.br.projeto_springai.domain.TransactionRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class PersistTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "persist-transaction", description = "Persite uma nova transação financeira")
    public TransactionOutput execute(TransactionPersistInput input){
        var transaction = transactionRepository.save(new Transaction(
                input.description(),
                input.amount(),
                input.category()
        ));
        return TransactionOutput.from(transaction);
    }
}
