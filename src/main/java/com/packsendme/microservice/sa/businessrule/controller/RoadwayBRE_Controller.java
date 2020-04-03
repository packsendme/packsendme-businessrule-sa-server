package com.packsendme.microservice.sa.businessrule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.packsendme.microservice.sa.businessrule.service.ConsumerBRE_Service;
import com.packsendme.microservice.sa.businessrule.service.ProduceBRE_Service;
import com.packsendme.roadway.bre.rule.model.RoadwayCostsBRE_Model;
import com.packsendme.roadway.bre.rule.model.RoadwayInstanceBRE_Model;

@RestController
@RequestMapping("/bre/sa/roadway")
public class RoadwayBRE_Controller {
	
	@Autowired
	private ProduceBRE_Service produceRuleSA; 
	
	@Autowired
	private ConsumerBRE_Service consumerRuleSA; 
	

	//========================================================================================
	// METHOD POST|GET :: ROADWAY-BRE
	//========================================================================================//

	private List<String> messages = new ArrayList<String>();
	
	@PostMapping("/topic/instance")
	public ResponseEntity<?> postRoadwayInstanceBRE_SA(@Validated @RequestBody RoadwayInstanceBRE_Model breObject) {		
		try {
			return produceRuleSA.sendRoadwayInstanceTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/topic/costs")
	public ResponseEntity<?> postRoadwayCostsBRE_SA(@Validated @RequestBody RoadwayCostsBRE_Model breObject) {		
		try {
			return produceRuleSA.sendRoadwayCostsTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/topic/instance")
	public List<String> getRoadwayInstanceBRE_SA() {		
		return messages;
	}
	
	@KafkaListener(groupId = "Java", topics = "topicRoadwayBRE_SA_Instance", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMessages(String data) {		
		messages.add(data);
		return messages;
	}
	
	
	
	@GetMapping("/topic/costs")
	public ResponseEntity<?> getRoadwayCostsBRE_SA() {		
		try {
			return consumerRuleSA.consumerRoadwayTopicCosts();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
