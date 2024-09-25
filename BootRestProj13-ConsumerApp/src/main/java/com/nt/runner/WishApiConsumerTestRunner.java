package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class WishApiConsumerTestRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		//create rest template class obj
		RestTemplate template = new RestTemplate();
		//prepare base url
		String baseUrl="http://localhost:3031/BootRestProj13-API-Provider/wish-api/wish";
		//invoke the API service/Operation
		ResponseEntity<String> response=template.getForEntity(baseUrl, String.class);
		//show the results
		System.out.println("output is::"+response.getBody());
		System.out.println("status code is::"+response.getStatusCodeValue());
		System.out.println("status code::"+response.getStatusCode());
		
		System.out.println("=====================================");
		
		String result=template.getForObject(baseUrl, String.class);
		System.out.println("output is::"+result);
		
	}
	
	
	
	
}
