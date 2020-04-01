package com.packsendme.microservice.sa.businessrule.consumer.component;

public abstract class ConsumerBRE_Abstract {
	
	private String msg_Topic_instance;
	private String msg_Topic_costs;

	public String getMsg_Topic_instance() {
		return msg_Topic_instance;
	}
	public void setMsg_Topic_instance(String msg_Topic_instance) {
		this.msg_Topic_instance = msg_Topic_instance;
	}
	public String getMsg_Topic_costs() {
		return msg_Topic_costs;
	}
	public void setMsg_Topic_costs(String msg_Topic_costs) {
		this.msg_Topic_costs = msg_Topic_costs;
	}
	public abstract void receiveTopic_instance(String msg);
	public abstract void receiveTopic_cots(String msg);
	
	
	

}
