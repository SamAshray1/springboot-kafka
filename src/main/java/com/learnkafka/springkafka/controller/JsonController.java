package com.learnkafka.springkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnkafka.springkafka.kafka.JsonKafkaProducer;
import com.learnkafka.springkafka.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonController {
	
	private JsonKafkaProducer kafkaProducer;
	
	public JsonController(JsonKafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}

	
	@PostMapping("/publish")
	private ResponseEntity<String> publish(@RequestBody User user) {
		
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent.");
	}


}
