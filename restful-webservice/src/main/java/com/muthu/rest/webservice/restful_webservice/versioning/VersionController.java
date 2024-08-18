package com.muthu.rest.webservice.restful_webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	private V1Person v1person;
	
	@GetMapping(path = "/personv1")
	public V1Person getV1Person() {
		return new V1Person("Muthu");
	}
	
	@GetMapping(path="/personv2")
	public V2Person getV2Person() {
		return new V2Person(new Name("Muthukumar", "Sakthivel"));
	}
	
	
	@GetMapping(path="/person", params = "version=2")
	public V2Person getV2PersonParamRequest() {
		return new V2Person(new Name("Muthukumar", "Sakthivel"));
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public V1Person getV1PersonRequestParamater() {
		return new V1Person("Muthu");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public V1Person getV1HeaderPersonRequestParamater() {
		return new V1Person("Muthu");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public V2Person getV2HeaderPersonRequestParamater() {
		return new V2Person(new Name("Muthukumar", "Sakthivel"));
	}
	
	@GetMapping(path = "/person/accept", produces = "application/person1.app-v1+json")
	public V1Person getV1HeaderPersonAcceptParamater() {
		return new V1Person("Muthu");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/person2.app-v2+json")
	public V2Person getV2HeaderPersonAcceptParamater() {
		return new V2Person(new Name("Muthukumar", "Sakthivel"));
	}
}
