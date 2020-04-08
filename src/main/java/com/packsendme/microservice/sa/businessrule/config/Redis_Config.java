package com.packsendme.microservice.sa.businessrule.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class Redis_Config {
	
	@Value(value = "${spring.redis.host}")
	public String REDIS_HOSTNAME;
	
	@Value(value = "${spring.redis.port}")
	public int REDIS_PORT;
	
	@Value(value = "${spring.redis.password}")
	public String REDIS_PWD;
	
	@Bean
	protected JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(REDIS_HOSTNAME,REDIS_PORT);
		config.setPassword(REDIS_PWD);
		JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().build();
		JedisConnectionFactory factory = new JedisConnectionFactory(config,jedisClientConfiguration);
		factory.afterPropertiesSet();
		return factory;
	}
 
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new GenericToStringSerializer<Object>(Object.class));
		redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
	    redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
	    redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

    
}
