package com.metacube.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.training.shape.SmtpMailSender;
import com.metacube.training.shape.MockMailSender;

@Configuration
public class AppConfig {

	
	/*
	 * bean name method to solve multiple component
	 */
	@Bean("a")
	
	public SmtpMailSender smtp() {
		return new SmtpMailSender();
	}
	
	@Bean("b")
	
	public MockMailSender mock() {
		return new MockMailSender();
	}
	
	
}
