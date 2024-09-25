package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishApiConsumerTestRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create rest template class obj
		RestTemplate template = new RestTemplate();
		// prepare base url
		String baseUrl = "http://localhost:3031/BootRestProj13-API-Provider/wish-api/register";
		// prepare the json body
		String json_body = "{\"aid\":1001,\"aname\":\"somanath\",\"addrs\":\"hyd\",\"income\":78000.0}";
		// prepare headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// preparethe request object
		HttpEntity<String> request = new HttpEntity<String>(json_body, headers);
		// invoke the API service/Operation
		ResponseEntity<String> response = template.postForEntity(baseUrl, request, String.class);
		// show the results
		System.out.println("output is::" + response.getBody());
		System.out.println("status code is::" + response.getStatusCodeValue());
		System.out.println("status code::" + response.getStatusCode());

		System.out.println("=====================================");

		String result = template.postForObject(baseUrl, request,String.class);
		System.out.println("output is::" + result);
		

	}

}
