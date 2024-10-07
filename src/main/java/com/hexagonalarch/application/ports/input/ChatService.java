package com.hexagonalarch.application.ports.input;

import com.hexagonalarch.application.domain.request.ChatRequest;
import com.hexagonalarch.application.domain.response.ChatResponse;

public interface ChatService {

    ChatResponse chat(ChatRequest chatRequest);

}
