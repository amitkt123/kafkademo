package com.producerService.Producer_Service.controller;


import com.producerService.Producer_Service.Service.KafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producerapi")
public class Controller {

    @Autowired
    private KafkaPublisher kafkaPublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessageToTopics(@PathVariable String message) {
        try{
            kafkaPublisher.SendMessageToTopic(message);
            return ResponseEntity.ok("message published");
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }

    }


}
