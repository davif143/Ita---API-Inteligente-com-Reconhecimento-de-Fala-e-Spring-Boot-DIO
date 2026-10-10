package com.br.projeto_springai;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPENAI_API_KEY", matches = ".+")
public class ToolCallingIT {

    @Autowired
    OpenAiChatModel openAiChatModel;

    static class MathTools {
        @Tool(description = "soma dois números interos, a e b.")
        public int soma(int a, int b) {
            return a + b;
        }

        @Tool(description = "subtraia dois números, a e b")
        public int sub(int a, int b){
            return a - b;
        }
    }

    @Test
    void executeSoma(){
        var chatClient = ChatClient.builder(openAiChatModel)
                .defaultSystem("Você é um matematico.")
                .defaultTools(new MathTools())
                .build();

        var response = chatClient.prompt("Some 10 mais 20. Depois subtraia 30 do resultado anterior.")
                .call().content();

        assertThat(response).contains("0");
        System.out.println(response);
    }
}
