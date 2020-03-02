package com.packsendme.microservice.businessrule.sa.config;

//@EnableKafka
//@Configuration
public class Consumer_Config {
	
	/*
	@Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "groupId");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    return new DefaultKafkaConsumerFactory<>(props);
	}
	 
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> 
		kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());
	    return factory;
	}
	
	*/
	
}
