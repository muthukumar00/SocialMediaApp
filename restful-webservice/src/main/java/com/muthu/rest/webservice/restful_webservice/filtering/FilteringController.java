package com.muthu.rest.webservice.restful_webservice.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
 
	@GetMapping(path="/dynamic-filter")
	public MappingJacksonValue getBean() {
		SomeBean someBean = new SomeBean("fields1", "field2", "field3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
				
	}
	
	@GetMapping(path = "/dynamic-filter-list")
	public MappingJacksonValue getListBean() {
		
		
		List<SomeBean> List = Arrays.asList(new SomeBean("field1", "field2", "field3"),
				new SomeBean("field4", "field5", "field6"),
				new SomeBean("field7", "field8", "field9"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(List);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeFilter", simpleBeanPropertyFilter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	@GetMapping(path = "/static-filter")
	public SomeBean getStaticfilter() {
		return new SomeBean("field1", "field2", "field3");
	}
}
