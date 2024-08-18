package com.muthu.rest.webservice.restful_webservice.versioning;

public class V1Person {
	
	private String name;
	
	public V1Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "V1Person [name=" + name + "]";
	}
	
}
