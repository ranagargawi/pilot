package com.example.pilot.service;
import com.example.pilot.model.Message;
import com.example.pilot.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;@Service
public class MessageService {

    @Autowired
    private MessageRepository repo;

    public Message saveMessage(Message msg) {
        return repo.save(msg);
    }

    public List<Message> getChatHistory(String user1, String user2) {
        return repo.findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(user1, user2, user1, user2);
    }
}
