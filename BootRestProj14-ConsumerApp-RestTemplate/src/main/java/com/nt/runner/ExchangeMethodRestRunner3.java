package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ExchangeMethodRestRunner3 implements CommandLineRunner{

	
	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		//prepare base url
		String baseUrl="http://localhost:3031/BootRestProj14-ProviderApp/wish-api/register";
		// prepare the json body
		String json_body = "{\"aid\":1001,\"aname\":\"somanath\",\"addrs\":\"hyd\",\"income\":78000.0}";
		//prepare rquest headers
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare HttpEntity object having header and body
		HttpEntity<String> req=new HttpEntity<>(json_body,headers);
		//invoke the API service/Operation
		ResponseEntity<String> response=template.exchange(baseUrl,HttpMethod.POST,req, String.class);
		//show the results
		System.out.println("output is::"+response.getBody());
		System.out.println("status code::"+response.getStatusCode());
		
		
	}
	
	
	
	
}
