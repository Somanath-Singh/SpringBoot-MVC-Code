package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ExchangeMethodRestRunner2 implements CommandLineRunner{

	
	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		//prepare base url
		String baseUrl="http://localhost:3031/BootRestProj14-ProviderApp/wish-api/wish/{id}/{name}";
		//invoke the API service/Operation
		ResponseEntity<String> response=template.exchange(baseUrl,HttpMethod.GET,null, String.class,1000,"Somanath");
		//show the results
		System.out.println("output is::"+response.getBody());
		System.out.println("status code::"+response.getStatusCode());
		
		
	}
	
	
	
	
}
