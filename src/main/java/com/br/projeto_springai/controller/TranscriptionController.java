package com.br.projeto_springai.controller;

import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class TranscriptionController {

    private final TranscriptionModel transcriptionModel;

    public TranscriptionController(TranscriptionModel transcriptionModel) {
        this.transcriptionModel = transcriptionModel;
    }

    @PostMapping("/transcption")
    String transcribe(@RequestParam("file")MultipartFile file){
        var resource = file.getResource();
        return transcriptionModel.transcribe(resource);
    }
}
