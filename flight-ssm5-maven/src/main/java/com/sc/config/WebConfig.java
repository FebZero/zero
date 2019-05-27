package com.sc.config;


import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.sc.controller")
public class WebConfig implements WebMvcConfigurer {

	@Bean // 配置jsp视图解析器
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		// 使用jstl视图
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Override // 配置静态资源
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	
	@Bean//Servlet3的文件上传
	MultipartResolver multipartResolver() throws IOException{
		return new StandardServletMultipartResolver();
	}

//	@Override //SpringMVC自定义转换器
//	public void addFormatters(FormatterRegistry registry) {
//		registry.addConverter(new ArrayToStringConverter());
//		WebMvcConfigurer.super.addFormatters(registry);
//	}
	
}
