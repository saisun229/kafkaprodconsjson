package com.ok.app.kafkaproducerexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import com.ok.app.kafkaproducerexample.model.User;


@SpringBootApplication
public class KafkaProducerExampleApplication  implements ApplicationRunner {


		
		
	@Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "Kafka_Example_json";
	
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerExampleApplication.class, args);
	}


	       public void sendMessage() {
	           kafkaTemplate.send(TOPIC, new User("saiiiii", "kafka", 12000));
	           }
		   
			
		   @Override
		   public void run(ApplicationArguments args) throws Exception {
			   sendMessage();
		   }
		
		
	}
