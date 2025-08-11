package com.example.pilot.controller;


import com.example.pilot.dto.AuthRequest;
import com.example.pilot.dto.MessageRequest;
import com.example.pilot.service.AuthService;
import com.example.pilot.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> saveMessage(@RequestBody MessageRequest request) {
        
        String token = messageService.saveMessage(request.getSenderId(), request.getRecieverId(), request.getContent(), Instant.now()   );
        return ResponseEntity.ok(token);
      }
}
