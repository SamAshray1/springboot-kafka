package com.learnkafka.springkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnkafka.springkafka.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class Controller {
	
	private KafkaProducer kafkaproducer;
	
	public Controller(KafkaProducer kafkaproducer) {
		super();
		this.kafkaproducer = kafkaproducer;
	}

	// http://localhost:8080/api/v1/kafka/publish?message=hello world
	@GetMapping("/publish")
	public ResponseEntity<String> putMessages(@RequestParam("message") String message) {
		
		kafkaproducer.SendMessage(message);
		
		return ResponseEntity.ok("Message sent to topic.");
		
	}

}
