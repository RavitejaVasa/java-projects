package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.KafkaInter;
import com.example.demo.model.KafkaModel;


@Component
public class KafkaConsumerService {
	
	@Autowired
	private KafkaInter kafkarepo;
	
	@KafkaListener(topics ="sample-topic",groupId = "group-id")
	public void listen(String message) {
		KafkaModel kf = new KafkaModel();
		String []messageX = message.split(",");
		kf.setSNO(Integer.parseInt(messageX[0]));
		kf.setUsername(messageX[1]);
		kafkarepo.save(kf);
		
	}


}
