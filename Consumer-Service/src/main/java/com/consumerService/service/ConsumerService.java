package com.consumerService.service;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ConsumerService {

    Logger logger = Logger.getLogger(ConsumerService.class.getName());

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @KafkaListener(topics = "orders-topic", groupId = "listener-group-1")
    public void consumerService(ConsumerRecord<String, String> consumerRecord) {
        logger.log(Level.INFO, "Consumed message: " + consumerRecord.toString());
    }

}
