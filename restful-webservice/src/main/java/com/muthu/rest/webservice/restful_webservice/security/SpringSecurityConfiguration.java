package com.muthu.rest.webservice.restful_webservice.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//1. All requst should be authentication
		http.authorizeHttpRequests( auth -> auth.anyRequest().authenticated());
		
		// 2 if a request is not authenticated , a web page is show
		http.httpBasic(withDefaults());
		
		http.csrf().disable();
		return http.build();
	}

}
