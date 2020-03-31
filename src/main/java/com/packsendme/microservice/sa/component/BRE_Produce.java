package com.packsendme.microservice.sa.component;

public interface BRE_Produce{
	
	public String sendTopic(String data, String topic);
	public String getURLTopic(String topic);
}
