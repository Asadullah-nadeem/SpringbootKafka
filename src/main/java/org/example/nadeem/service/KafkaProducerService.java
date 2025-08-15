package org.example.nadeem.service;

import org.example.nadeem.controller.MessageRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void saveAndSend(String messageText) {
        Message message = new Message(messageText);
        messageRepository.save(message);
        kafkaTemplate.send(TOPIC, messageText);
        System.out.println("Message saved & sent: " + messageText);
    }
}
