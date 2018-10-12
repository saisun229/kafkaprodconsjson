package com.ok.app.kafkaconsumerexample.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ok.app.kafkaproducerexample.model.User;





@Service
public class KafkaConsumer {
	
 /*   @KafkaListener(topics = "Kafka_Example", groupId = "group_id",
    		containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("Consumed message from group_id: " + message);
    }
*/

 

    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message from group_json: " + user);
    }
    
}



