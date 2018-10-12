package com.ok.app.kafkaconsumerexample.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.ok.app.kafkaproducerexample.model.User;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableKafka
public class KafkaConfiguration {

/*	@bean
	public ConsumerFactory<String, User> consumerFactory() {
	Map<String, Object> config = new HashMap<>();
	config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
	config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	config.put(JsonDeserializer.TRUSTED_PACKAGES, "package.where.domain.object.resides");
	return new DefaultKafkaConsumerFactory<>(config);
	}
*/

 @Bean
    public ConsumerFactory<String, User> userConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        
        return new DefaultKafkaConsumerFactory<>(config);
        		} 

   @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }

}


/*Description:

Parameter 1 of method kafkaListenerContainerFactory in org.springframework.boot.autoconfigure.kafka.KafkaAnnotationDrivenConfiguration required a bean of type 'org.springframework.kafka.core.ConsumerFactory' that could not be found.
	- Bean method 'kafkaConsumerFactory' in 'KafkaAutoConfiguration' not loaded because @ConditionalOnMissingBean (types: org.springframework.kafka.core.ConsumerFactory; SearchStrategy: all) found beans of type 'org.springframework.kafka.core.ConsumerFactory' userConsumerFactory
	- User-defined bean method 'userConsumerFactory' in 'KafkaConfiguration'


Action:

Consider revisiting the entries above or defining a bean of type 'org.springframework.kafka.core.ConsumerFactory' in your configuration.

*/
/*
@Bean
public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> config = new HashMap<>();

    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

    return new DefaultKafkaConsumerFactory<>(config);
}


@Bean
public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
}*/
