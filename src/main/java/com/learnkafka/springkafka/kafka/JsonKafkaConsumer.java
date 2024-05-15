package com.learnkafka.springkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.learnkafka.springkafka.payload.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "tutorials", groupId = "myGroup")
	public void consumer(User user) {
		LOGGER.info(String.format("Json Message received -> %s", user.toString()));
		
	}
}
