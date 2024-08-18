package com.muthu.rest.webservice.restful_webservice.versioning;

import com.muthu.rest.webservice.restful_webservice.versioning.Name;
public class V2Person {
	
	private Name Name;
	
	

	public V2Person(Name name) {
		super();
		Name = name;
	}

	public Name getName() {
		return Name;
	}

	public void setName(Name name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "V2Person [Name=" + Name + "]";
	}
	
}
