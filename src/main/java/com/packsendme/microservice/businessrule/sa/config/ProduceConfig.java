package com.packsendme.microservice.businessrule.sa.config;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@org.springframework.context.annotation.Configuration
public class ProduceConfig {

	
	@Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<String, String> producerFactory() throws UnknownHostException {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
		//configProps.put(ProducerConfig.LINGER_MS_CONFIG,160000);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.LINGER_MS_CONFIG,1);
		configProps.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG,20000);
		configProps.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,30000);
		configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 1000);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        try {
			return new KafkaTemplate<>(producerFactory());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
    }


}
