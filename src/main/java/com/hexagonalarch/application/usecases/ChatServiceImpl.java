package com.hexagonalarch.application.usecases;

import com.hexagonalarch.domain.request.ChatRequest;
import com.hexagonalarch.domain.response.ChatResponse;
import com.hexagonalarch.application.ports.inbound.ChatService;
import com.hexagonalarch.config.EnvironmentConfig;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    ChatLanguageModel model = OpenAiChatModel.withApiKey(EnvironmentConfig.OPEN_AI_KEY);

    @Override
    public ChatResponse chat(ChatRequest chatRequest) {
        var modelResponse = model.generate(chatRequest.getText());
        return ChatResponse.builder().text(modelResponse).build();
    }
}
