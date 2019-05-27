package com.sc.config;

import java.util.EnumSet;
import java.util.HashMap;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * 该类相当于web.xml
 * 需要servlet3.0以上
 * @author Administrator
 *
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//字符编码过滤器
		Dynamic filterRegistration = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filterRegistration.setInitParameters(new HashMap<String,String>(){
			{
				put("encoding", "utf-8");
				put("forceEncoding", "true");
			}
		}
				);
		filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		
		//spring-session过滤器 使用redis保存session
//		Dynamic filterRegistration2 = servletContext.addFilter("springSessionRepositoryFilter", DelegatingFilterProxy.class);
		filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.ERROR), true, "/*");
		 System.out.println("----------WebInitializer---------------");
		super.onStartup(servletContext);
	}
	
	@Override//加载Spring全局根配置
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}

	@Override//加载SpringMVC配置
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
	}

	/**
	 * 相当于xml中配置DispatcherServlet
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(javax.servlet.ServletRegistration.Dynamic registration) {
		// TODO Auto-generated method stub
		super.customizeRegistration(registration);
		//设置上传文件所保存的的location、maxFileSize、maxRequestSize、fileSizeThreshold
		//其中location必须要配置
		registration.setMultipartConfig(new MultipartConfigElement("",2097152,4194304,0));
	}
}
