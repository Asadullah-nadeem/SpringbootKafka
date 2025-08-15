package org.example.nadeem.service;

import org.example.nadeem.controller.MessageRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "my_topic";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MessageRepository messageRepository;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate,
                                MessageRepository messageRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageRepository = messageRepository;
    }
    @GetMapping("/send")
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Message saved successfully: " + message);
    }
}
