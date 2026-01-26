package com.jane.ollama.controller;

import com.jane.ollama.model.CountryCities;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class StructuredOutputController {
    private final ChatClient chatClient;
    public StructuredOutputController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(new SimpleLoggerAdvisor())
//                .defaultSystem("You MUST return a JSON object with fields:\n" +
//                        "- country: string\n" +
//                        "- cities: array of strings\n" +
//                        "\n" +
//                        "DO NOT return a raw array.\n" +
//                        "DO NOT omit the object wrapper.\n")
                .build();
    }

    @GetMapping("/chat-bean")
    public ResponseEntity<CountryCities> chatBean(@RequestParam("message") String message){
        CountryCities response = chatClient
                .prompt()
                .user(message)
                .call()
                .entity(new BeanOutputConverter<>(CountryCities.class));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/chat-list")
    public ResponseEntity<List<String>> chatList(@RequestParam("message") String message){
        List<String> response = chatClient
                .prompt()
                .user(message)
                .call()
                .entity(new ListOutputConverter());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/chat-map")
    public ResponseEntity<Map<String, Object>> chatLMap(@RequestParam("message") String message){
        Map<String, Object> response = chatClient
                .prompt()
                .user(message)
                .call()
                .entity(new MapOutputConverter());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/chat-bean-list")
    public ResponseEntity<List<CountryCities>> chatBeanList(@RequestParam("message") String message){
        List<CountryCities> response = chatClient
                .prompt()
                .user(message)
                .call()
                .entity(new ParameterizedTypeReference<List<CountryCities>>() {});
        return ResponseEntity.ok(response);
    }
}
