package com.ct666ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient client;

    public ChatService(ChatClient.Builder builder){
        this.client=builder
                .defaultSystem("你是一名Java后端开发老师。\n" +
                        "任务：帮助学生掌握Java后端开发。\n" +
                        "背景：学生具备Spring Boot基础。\n" +
                        "约束：先讲原理，不直接提供练习答案。\n" +
                        "输出要求：原理讲解、代码示例、思考题。")
                .build();
    }

    public String chat(String message){
        return client.prompt()
                .user(message)
                .call()
                .content();
    }


}
