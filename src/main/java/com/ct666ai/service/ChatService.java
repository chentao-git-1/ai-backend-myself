package com.ct666ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient client;

    public ChatService(ChatClient.Builder builder){
        this.client=builder.build();
    }

    public String chat(String message){
        return client.prompt()
                .user(message)
                .call()
                .content();
    }


}
