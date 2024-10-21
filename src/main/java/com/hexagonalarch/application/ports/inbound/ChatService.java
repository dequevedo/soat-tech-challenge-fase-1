package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.application.dto.request.ChatRequest;
import com.hexagonalarch.application.dto.response.ChatResponse;

public interface ChatService {

    ChatResponse chat(ChatRequest chatRequest);

}
