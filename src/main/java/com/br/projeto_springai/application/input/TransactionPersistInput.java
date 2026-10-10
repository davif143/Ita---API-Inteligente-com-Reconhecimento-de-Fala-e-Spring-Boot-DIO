package com.br.projeto_springai.application.input;

import com.br.projeto_springai.domain.Category;
import org.springframework.ai.tool.annotation.ToolParam;

public record TransactionPersistInput(
        @ToolParam(description = "Descrição do gasto")
        String description,
        @ToolParam(description = "Valor do gasto")
        long amount,
        @ToolParam(description = "Categoria do gasto")
        Category category
) {
}
