package com.ssafy.pms.config;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.ssafy.pms.model.dao","com.ssafy.pms.model.service"}) // 패키지가 여러개라 배열로.
/* <tx:annotation-driven/> 트랜잭션 설정 */
@EnableTransactionManagement
public class ApplicationConfig {
	
	/*
	 * 	<bean  id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"  destroy-method="close">
			<property name="driverClassName"  	value="com.mysql.cj.jdbc.Driver" />
			<property name="url"  				value="jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&amp;useSSL=false&amp;allowPublicKeyRetrieval=true" />
			<property name="username"  			value="ssafy" />
			<property name="password"  			value="ssafy" />
			<property name="maxActive"  		value="20" />
		</bean>
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		ds.setUsername("ssafy");
		ds.setPassword("ssafy");
		ds.setMaxActive(20);
		return ds;
	}
	
	/* 
	 * 	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
			<property name="dataSource"  ref="dataSource"/>
			<!-- MyBatis 기본 설정 XML 등록 -->
			<property name="configLocation"  value="classpath:spring/SqlMapConfig.xml"/>
		</bean>
	*/
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource ds) {
		SqlSessionFactoryBean sfac = new SqlSessionFactoryBean();
		sfac.setDataSource(ds);
		String configLoc = "classpath:spring/SqlMapConfig.xml";
		sfac.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLoc));
		return sfac;
	}
	
	/*	
	 	<bean  id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
			<constructor-arg ref="sqlSessionFactory"/>		
		</bean>  
	*/
	@Bean
	public SqlSession sqlSession(SqlSessionFactoryBean sfac) throws Exception {
		return new SqlSessionTemplate(sfac.getObject());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
	
	
	
	
	
}
