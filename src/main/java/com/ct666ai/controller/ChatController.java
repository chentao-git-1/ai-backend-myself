package com.ct666ai.controller;

import com.ct666ai.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Map<String,String> health(@RequestBody Map<String,String> request){
        String message =request.get("message");



        return Map.of(
                "role", "assistant",
                "content", "你刚刚发送了：" + message
        );

    }


}
