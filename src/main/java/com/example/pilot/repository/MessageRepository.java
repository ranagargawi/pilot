package com.example.pilot.repository;
import com.example.pilot.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    // Custom method to fetch messages between two users
    List<Message> findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(
        String sender1, String receiver1,
        String sender2, String receiver2
    );


}
