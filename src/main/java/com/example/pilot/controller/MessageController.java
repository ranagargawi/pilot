package com.example.pilot.controller;


import com.example.pilot.dto.AuthRequest;
import com.example.pilot.service.AuthService;
import com.example.pilot.service.MessageService;
import com.example.pilot.model.Message;
import com.example.pilot.repository.MessageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public void saveMessage(Message msg) {
        
        messageService.saveMessage(msg);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Message>> getChatHistory(@RequestParam String user1, @RequestParam String user2) {
        List<Message> chatHistory = messageService.getChatHistory(user1, user2);
        return ResponseEntity.ok(chatHistory);
    }
}
