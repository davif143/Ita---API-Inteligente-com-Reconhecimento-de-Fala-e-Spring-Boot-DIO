package com.br.projeto_springai.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    ChatClient chatChatClient(ChatClient.Builder builder){
        return builder.build();
    }
}
