package com.sc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis数据库配置
 * @author 
 *
 */
//@Configuration
public class RedisConifg {
	@Value("${redis.host}")
	private String hostName;
	@Value("${redis.port}")
	private int port;
	@Value("${redis.password}")
	private String password;
	@Value("${redis.dbIndex}")
	private int dbIndex;
	
	@Bean//Redis密码
	public RedisPassword redisPassword() {
		return RedisPassword.of(password);
	}
	/**
	 * RedisStandaloneConfiguration 
	 * RedisSentinelConfiguration 
	 * RedisClusterConfiguration  
	 * @param redisPassword 
	 * @return
	 */
	@Bean// Redis配置(用户名、密码、数据库)
	public RedisStandaloneConfiguration redisStandaloneConfiguration(RedisPassword redisPassword) {
		RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration(hostName,port);
		rsc.setPassword(redisPassword);
		rsc.setDatabase(dbIndex);
		return rsc;
	}
	
	
	@Bean//Redis连接工厂 s使用Jedis连接
   public RedisConnectionFactory redisConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
	   return new JedisConnectionFactory(redisStandaloneConfiguration);
   }
	
	@Bean//字符串序列化器
	public StringRedisSerializer stringRedisSerializer() {
		return new StringRedisSerializer();
	}
	
	@Bean//JSON序列化器
	public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer() {
		return new GenericJackson2JsonRedisSerializer();
	}
	
	
	@Bean//字符串类型操作模板
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		StringRedisTemplate redis = new StringRedisTemplate();
		redis.setConnectionFactory(redisConnectionFactory);
		return redis;
        
	}
	
	@Bean//通用型操作模板
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory,
			StringRedisSerializer stringRedisSerializer,
			GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer
			){
		RedisTemplate<String,Object> redis = new RedisTemplate<>();
		redis.setKeySerializer(stringRedisSerializer);
		//使用JSON序列化器
		redis.setValueSerializer(genericJackson2JsonRedisSerializer);
		redis.setHashKeySerializer(genericJackson2JsonRedisSerializer);
		redis.setHashValueSerializer(genericJackson2JsonRedisSerializer);
		redis.setConnectionFactory(redisConnectionFactory);
		redis.afterPropertiesSet();
		return redis;
	}

}
