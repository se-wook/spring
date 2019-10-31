package com.ssafy.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/*bean configuration 설정 위한  Annotation*/
@Configuration							
/*<context:component-scan base-package=''/> 설정을 위한   Annotation*/
@ComponentScan("com.ssafy.pms")
/*<mvc:annotation-driven />*/
@EnableWebMvc

/** mvc-config.xml을 대체할 Configuration*/
public class MvcConfig extends  WebMvcConfigurerAdapter{
	/* ViewResolver를 설정
	 * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/"/>
        <property name="suffix" value=".jsp"/>
	   </bean> 
	*/
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = 
				new InternalResourceViewResolver("/", ".jsp");
		return resolver;
	}
	
	/* <mvc:resources location="/resources/" 	mapping="/**"/> 설정     */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
		
		//스웨거 설정
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}












