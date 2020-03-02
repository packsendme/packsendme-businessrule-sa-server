package com.packsendme.microservice.sa.component;

public interface BREConsumer_Interface {
	
	public void receiveTopic(String msg);
	public String contextMsg();

}
