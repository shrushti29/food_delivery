package com.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.utils.PasswordUtils;

@Configuration
public class Config {
	
	@Bean
	public PasswordUtils passwordUtils() {
		return new PasswordUtils();
	}

}
