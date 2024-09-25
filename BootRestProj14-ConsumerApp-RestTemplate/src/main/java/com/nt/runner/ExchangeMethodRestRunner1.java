package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ExchangeMethodRestRunner1 implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
		//invoke the exchange()
		String serviceUrl="http://localhost:3031/BootRestProj14-ProviderApp/wish-api/wish";
		//invoke exchange()
		ResponseEntity<String> response=template.exchange(serviceUrl, HttpMethod.GET,null,String.class);
		
		//display output
		System.out.println("output is::"+response.getBody());
		System.out.println("status code::"+response.getStatusCode().value());
		
		System.out.println("=====================================");
		
		
	}
	
	
	
	
}
