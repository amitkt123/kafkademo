package com.producerService.Producer_Service.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisher {

    @Autowired
    KafkaTemplate<String , String > kafkaTemplate;

    public void SendMessageToTopic(String message){
        try{
            kafkaTemplate.send("orders-topic", 2, "Kafka Test Message", message);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
