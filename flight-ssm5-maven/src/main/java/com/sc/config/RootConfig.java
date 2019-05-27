package com.sc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource({ "classpath:redis.properties", "classpath:jdbc.properties", "classpath:druid.properties" })
@ImportResource("classpath:spring.xml")
@EnableTransactionManagement//事务管理
@ComponentScan(basePackages= {"com.sc",
//		"org.springframework.session.data.redis.config.annotation.web.http"
		},
excludeFilters= {
		@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
})
//@Import(RedisHttpSessionConfiguration.class)
public class RootConfig {
	//Redis-Session配置
//    @Bean
//	public RedisHttpSessionConfiguration redisHttpSessionConfiguration() {
//    	System.out.println("---RedisHttpSessionConfiguration---");
//		RedisHttpSessionConfiguration rhsc = new RedisHttpSessionConfiguration();
//		rhsc.setMaxInactiveIntervalInSeconds(600);//有效时间10分钟，默认30分钟
//		return rhsc;
//	}
    

	@Bean //事务管理器
	public PlatformTransactionManager txManager(DataSource druidDataSource) {
		return new DataSourceTransactionManager(druidDataSource);
	}

}
