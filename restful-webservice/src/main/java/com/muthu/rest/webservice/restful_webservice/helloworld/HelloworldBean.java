package com.muthu.rest.webservice.restful_webservice.helloworld;

public class HelloworldBean {
	
	private String message;

	public HelloworldBean(String string) {
		// TODO Auto-generated constructor stub
		this.message = string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloworldBean [message=" + message + "]";
	}
	}
