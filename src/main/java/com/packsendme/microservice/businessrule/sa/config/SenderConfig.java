package com.packsendme.microservice.businessrule.sa.config;

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

@org.springframework.context.annotation.Configuration
@EnableKafka
public class SenderConfig {

	
	@Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<String, String> producerFactory() {    	
		System.out.println("+++++++++++++++++++  bootstrapServers +++++++++++++++++++++ :: "+ bootstrapServers);

        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"167.172.152.184:9092");
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        props.put(ProducerConfig.RETRIES_CONFIG,0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,100);
        props.put(ProducerConfig.LINGER_MS_CONFIG,10);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,600000);
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }


}
