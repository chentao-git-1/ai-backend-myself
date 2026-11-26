package com.ct666ai.controller;

import com.ct666ai.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")

public class ChatController {


    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(
            @RequestBody Map<String, String> request) {

        String message = request.get("message");
        String conversationId = request.get("conversationId");

        String answer = chatService.chat(message, conversationId);

        return Map.of(
                "role", "assistant",
                "content", answer
        );
    }
    @PostMapping(
            value = "/chat/stream",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<String> streamChat(@RequestBody Map<String,String> request){
        // TODO：使用 Spring AI 实现流式模型调用
        // TODO 1：获取用户输入
        String message = request.get("message");

        String conversation=request.get("conversationId");
        // TODO 2：调用 ChatService 的流式方法
        Flux<String> stringFlux = chatService.streamChat(message,conversation);
        // TODO 3：返回 Flux
        return stringFlux;

    }



}
