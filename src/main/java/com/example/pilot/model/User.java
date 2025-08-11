package com.example.pilot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String email;
    private String password;

    // Getters and setters
}

