package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

//@Component
public class ExchangeMethodRestRunner4 implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
	
		//prepare base url
		String baseUrl="http://localhost:3031/BootRestProj14-ProviderApp/wish-api/report";
		//invoke the API service/Operation
		ResponseEntity<String> response=template.exchange(baseUrl, HttpMethod.GET,null,String.class);
		//show the results
		System.out.println("output is::"+response.getBody());
		System.out.println("status code is::"+response.getStatusCodeValue());
		System.out.println("status code::"+response.getStatusCode());
	
		System.out.println("====================================");
		//convert JSON text to model class obj using JACKSON API
		ObjectMapper mapper=new ObjectMapper();
		Actor actor=mapper.readValue(response.getBody(), Actor.class);
		System.out.println("Actor data is:"+actor);
		
	}
	
	
	
	
}
