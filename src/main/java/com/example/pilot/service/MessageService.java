package com.example.pilot.service;

import com.example.pilot.dto.AuthRequest;
import com.example.pilot.model.Message;
import com.example.pilot.model.User;
import com.example.pilot.repository.MessageRepository;
import com.example.pilot.repository.UserRepository;
import com.example.pilot.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class MessageService {
    @Autowired
    private final MessageRepository messageRepository;
    
 
    @Autowired
    private JwtService jwtService;

    MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String saveMessage(String senderId, String recieverId, String content,Instant timestamp) {
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(recieverId);
        message.setMessage(content);
        message.setTimestamp(timestamp);

        messageRepository.save(message);
        return jwtService.generateToken(senderId);
    }

}
