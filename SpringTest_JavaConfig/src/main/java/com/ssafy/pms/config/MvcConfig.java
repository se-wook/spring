package com.ssafy.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*	mvc-config.xml을 대체 (bean configuration)역할 대체 하기위한 Annotation		*/
@Configuration 
/* 	<context:component-scan base-package=''/> 대체 하기 위한 Annotation	*/
@ComponentScan("com.ssafy.pms.controller")
/* 	<mvc:annotation-driven /> 	*/
@EnableWebMvc
/** mvc-config.xml을 대체할 Configuration  */
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	/*
	 * ViewResolver 를 설정
	 * <bean class="org.springframework.web.servlet.view.InternamResourceViewResolver">
	 * 	<property name="prefix" value="/"/>
	 * 	<property name="suffix" value=".jsp"/>
	 * </bean>
	 */
	@Bean
	public ViewResolver viewresolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver("/", ".jsp");
		return resolver;
	}
	
	/*	<mvc:resources location="/resources/" 	mapping="/**"/> 설정 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
}
