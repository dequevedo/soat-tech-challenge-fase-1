package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.domain.request.ChatRequest;
import com.hexagonalarch.domain.response.ChatResponse;

public interface ChatService {

    ChatResponse chat(ChatRequest chatRequest);

}
