package com.sc.config;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;

/**
 * MyBatis数据库
 * @author 
 *
 */
@Configuration
public class MyBatisConfig {
	@Value("${jdbc.dialect}")
	private String helpDialect;
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${druid.initialSize}")
	private int initialSize;
	@Value("${druid.minIdle}")
	private int minIdle;
	@Value("${druid.maxActive}")
	private int maxActive;
	@Value("${druid.maxWait}")
	private int maxWait;
	@Value("${druid.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	@Value("${druid.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	@Value("${druid.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${druid.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${druid.testOnReturn}")
	private boolean testOnReturn;
	@Value("${druid.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	@Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
	@Value("${druid.defaultAutoCommit}")
	private boolean defaultAutoCommit;
	@Value("${druid.validationQuery}")
	private String validationQuery;
	@Value("${druid.filters}")
	private String filters; 
	@Value("${statementExecutableSqlLogEnable}")
	private boolean statementExecutableSqlLogEnable;
	
	private Resource configLocation = new ClassPathResource("mybatis.xml");
	private String mapperLocations = "classpath*:com/sc/mapper/*Mapper.xml";
	private String typeAliasesPackage = "com.sc.pojo";
	
	@Bean
	public Slf4jLogFilter slf4jLogFilter() {
		Slf4jLogFilter sf = new Slf4jLogFilter();
		sf.setStatementExecutableSqlLogEnable(statementExecutableSqlLogEnable);
		return sf;
	}
	
	/**
	 * 阿里云druid数据库连接池
	 * @param slf4jLogFilter
	 * @return
	 * @throws SQLException
	 */
	@Bean
	public DataSource druidDataSource(final Slf4jLogFilter slf4jLogFilter) throws SQLException {
		
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(driverClassName);
		dds.setUrl(url);
		dds.setUsername(username);
		dds.setPassword(password);
		dds.setInitialSize(initialSize);
		dds.setMinIdle(minIdle);
		dds.setMaxActive(maxActive);
		dds.setMaxWait(maxWait);
		dds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dds.setTestWhileIdle(testWhileIdle);
		dds.setTestOnBorrow(testOnBorrow);
		dds.setTestOnReturn(testOnReturn);
		dds.setPoolPreparedStatements(poolPreparedStatements);
		dds.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		dds.setDefaultAutoCommit(defaultAutoCommit);
		dds.setValidationQuery(validationQuery);
		dds.setFilters(filters);
		dds.setProxyFilters(new ArrayList<Filter>() {
			{
				add(slf4jLogFilter);
			}
		});
		return dds;
	}

	@Bean//PageHelper的分页拦截器
	public PageInterceptor pageInterceptor() {
		PageInterceptor pi = new PageInterceptor();
		Properties p = new Properties();
		//数据库方言
		p.setProperty("helperDialect", helpDialect);
		pi.setProperties(p);
		return pi;
	}
	
	@Bean("sqlSessionFactoryBean")
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource druidDataSource,
			PageInterceptor pageInterceptor) throws IOException {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setConfigLocation(configLocation);
		//路径字符串解析器
		ResourcePatternResolver rpr = new PathMatchingResourcePatternResolver();
		//解析路径
		sfb.setMapperLocations(rpr.getResources(mapperLocations));
		//设置查找别名的包，取代mybaitis中别名的配置
		sfb.setTypeAliasesPackage(typeAliasesPackage);
		sfb.setDataSource(druidDataSource);
		//分页拦截器
		Interceptor[] incs = new Interceptor[]{pageInterceptor};
		sfb.setPlugins(incs);
		//注册类型转换器
//		sfb.setTypeHandlers(new TypeHandler[] {
//				new MyBatisArrayStringTypeHandler()});
		return sfb;
	}
	
//	@Bean 造成@Value无法读取 因此使用xml中配置
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		MapperScannerConfigurer msc = new MapperScannerConfigurer();
//		msc.setBasePackage(mapperScannerPakage);
//		msc.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//		return msc;
//	}
}
