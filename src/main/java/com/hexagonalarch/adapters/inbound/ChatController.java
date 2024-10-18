package com.hexagonalarch.adapters.inbound;

import com.hexagonalarch.domain.request.ChatRequest;
import com.hexagonalarch.domain.response.ChatResponse;
import com.hexagonalarch.application.ports.inbound.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/chat")
    @ResponseStatus(HttpStatus.CREATED)
    public ChatResponse chat(@Valid @RequestBody ChatRequest chatRequest) {
        return chatService.chat(chatRequest);
    }

}