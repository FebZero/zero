package com.sc.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
/**
 * 注册缓存
 * @author 晨
 *
 */
//@Configuration第三方士大夫都是
//@EnableCaching
public class CacheConfig {
	@Value("${redis.expire.seconds}")
	private long expireSeconds;
	@Inject
	private RedisConnectionFactory redisConnectionFactory;
	
	@Bean 
	public CacheManager cacheManager() {
		CompositeCacheManager ccm = new CompositeCacheManager();
		List<CacheManager> list = new ArrayList<>();	
		RedisCacheManagerBuilder builder = RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory);
//		Set<String> cacheNames = new HashSet<String>() {{  
//	        add("student");//缓存名称在 redis里相当于一个命名空间student::key
//	    }};
//		builder.initialCacheNames(cacheNames); 
		builder.cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().
				//设置缓存过期时间为n秒后
				entryTtl(Duration.ofSeconds(expireSeconds)));
		RedisCacheManager rcm = builder.build();
		list.add(rcm);
		ccm.setCacheManagers(list);
		return ccm;
	}
}
