package com.br.projeto_springai;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPENAI_API_KEY", matches = ".+")
public class OpenAiTranscptionModelIT {

    @Autowired
    OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;


    @ParameterizedTest
    @CsvSource({
            "audio-1.mp3, 80 reais",
            "audio-2.mp3, 20 reais",
            "audio-3.mp3, 30 reais",
            "audio-4.mp3, 40 reais"
    })
    void contemPalavraChave_quandoAudioProcessado(String fileName, String palavraEsperada){
        var recording = new ClassPathResource("audio/" + fileName);

        var response = openAiAudioTranscriptionModel.call(recording);

        assertThat(response).contains(palavraEsperada);
        System.out.println(response);
    }

}
