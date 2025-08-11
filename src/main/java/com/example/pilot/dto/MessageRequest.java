package com.example.pilot.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
@Getter
@Setter
public class MessageRequest {
    private String senderId;
    private String recieverId;
    private String content;
    private Instant timestamp;
    // Getters and setters
}
