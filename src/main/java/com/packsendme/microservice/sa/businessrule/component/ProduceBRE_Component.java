package com.packsendme.microservice.sa.businessrule.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.packsendme.lib.common.constants.Topic_SA_Constants;
import com.packsendme.microservice.sa.businessrule.config.Topic_Config;

@Component
public class ProduceBRE_Component implements BRE_Produce {

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private Topic_Config topic_config;

	@Override
	public String sendTopic(String data, String topic) {
		try {
			String topic_url = getURLTopic(topic);
			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic_url, data);
			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
					@Override
		            public void onSuccess(SendResult<String, String> result) {
		            	System.out.println("<> Sent message=[" + data + "] with offset=[" + result.getRecordMetadata().offset() + "]");  
		            }
		            
		            @Override
		            public void onFailure(Throwable ex) {
		            	System.out.println("Unable to send message=["+ data + "] due to : " + ex.getMessage());
		            }
	       	});
			return data;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getURLTopic(String topic) {
		String topic_url = null;
		switch (topic) {
		case Topic_SA_Constants.TOPIC_ROADWAY_SA_Instance:
			topic_url = topic_config.topicRoadwayInstance;
			break;
			
		case Topic_SA_Constants.TOPIC_ROADWAY_SA_Costs:
			topic_url = topic_config.topicRoadwayCosts;
			break;

		case Topic_SA_Constants.TOPIC_AIRWAY_SA_Instance:
			topic_url = topic_config.topicAirwayInstance;
			break;

		case Topic_SA_Constants.TOPIC_AIRWAY_SA_Costs:
			topic_url = topic_config.topicAirwayCosts;
			break;

		case Topic_SA_Constants.TOPIC_MARITIMEWAY_SA_Instance:
			topic_url = topic_config.topicMaritimewayInstance;
			break;

		case Topic_SA_Constants.TOPIC_MARITIMEWAY_SA_Costs:
			topic_url = topic_config.topicMaritimewayCosts;
			break;

		default:
			break;
		}
		return topic_url;
	}
 	
}
