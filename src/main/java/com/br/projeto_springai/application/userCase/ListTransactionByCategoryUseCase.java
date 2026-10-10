package com.br.projeto_springai.application.userCase;

import com.br.projeto_springai.application.output.TransactionOutput;
import com.br.projeto_springai.domain.Category;
import com.br.projeto_springai.domain.TransactionRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTransactionByCategoryUseCase {
    private final TransactionRepository transactionRepository;

    public ListTransactionByCategoryUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "list-transaction-by-category", description = "Liste transações financeiras por categoria")
    public List<TransactionOutput> execute(@ToolParam(description = "Categoria de uma transação") Category category){
        return transactionRepository.findAllByCategory(category)
                .stream().map(TransactionOutput::from).toList();
    }
}
