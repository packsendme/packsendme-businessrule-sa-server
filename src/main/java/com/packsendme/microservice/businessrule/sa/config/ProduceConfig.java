package com.packsendme.microservice.businessrule.sa.config;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@org.springframework.context.annotation.Configuration
@EnableKafka
public class ProduceConfig {

	
	@Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<String, String> producerFactory() throws UnknownHostException {    	
		System.out.println("+++++++++++++++++++  bootstrapServers +++++++++++++++++++++ :: "+ bootstrapServers);

		Map<String, Object> configProps = new HashMap<>();
		configProps.put(
		ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"167.172.152.184:29092");
	//	configProps.put(ProducerConfig.ACKS_CONFIG,"1");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
	//	configProps.put(ProducerConfig.LINGER_MS_CONFIG,10000);
	//	configProps.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG,20000);
	//	configProps.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,50000);
	//	configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 10);

		return new DefaultKafkaProducerFactory<>(configProps);
		
		
		/*
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"167.172.152.184:29092");
        props.put(ProducerConfig.ACKS_CONFIG,"0");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        props.put(ProducerConfig.LINGER_MS_CONFIG,10);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 500000);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG,2000);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,900000);
        return new DefaultKafkaProducerFactory<>(props);
        */
		
        /*props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"167.172.152.184:9092");
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        props.put(ProducerConfig.RETRIES_CONFIG,0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,100);
        props.put(ProducerConfig.LINGER_MS_CONFIG,1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
         props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,300000); */
        
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        try {
			return new KafkaTemplate<>(producerFactory());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }


}
