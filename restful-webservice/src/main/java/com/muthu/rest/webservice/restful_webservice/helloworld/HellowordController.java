package com.muthu.rest.webservice.restful_webservice.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowordController {
	
	private MessageSource messageSource;
	
	public HellowordController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping(path = "/hello-world")
	public String hellworld() {
		return "Java-world";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloworldBean helloworldBean() {
		return new HelloworldBean("hello world");
	}
	
	@GetMapping(path = "/hello-world/pathvariable/{name}")
	public HelloworldBean helloworldpathvariable(@PathVariable String name) {
		return new HelloworldBean(String.format("Hi, %s",name));
	}
	
	@GetMapping(path = "/i18n")
	public String helloworldi18n() {
		
		Locale local = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", local);
	}
}
