package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.KafkaInter;
import com.example.demo.model.KafkaModel;
import com.example.demo.service.KafkaProducerService;

@RestController
public class KafkaDbController {
	@Autowired
	private KafkaInter kafkarepo;
	@Autowired
	private KafkaProducerService kafkaProducerService;
	

	
	@PostMapping("/message")
	public void sendmessagetokafka(@RequestParam String topic,@RequestParam String message) {
		
		kafkaProducerService.sendMessage(topic, message);
		
		
	}
	
	 @GetMapping("/messages")
	    public List<KafkaModel> getAllMessagesFromDatabase() {
	        return kafkarepo.findAll();
	    }
	

}
