package org.example.nadeem.controller;

import org.example.nadeem.service.KafkaProducerService;
import org.example.nadeem.service.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {


    private final KafkaProducerService kafkaProducerService;

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        Message msg = new Message(message);

        kafkaProducerService.save(msg);;
        return "Message saved successfully"  + message ;
    }
}
