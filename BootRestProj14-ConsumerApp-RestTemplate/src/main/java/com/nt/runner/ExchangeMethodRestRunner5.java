package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Component
public class ExchangeMethodRestRunner5 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		// prepare base url
		String baseUrl = "http://localhost:3031/BootRestProj14-ProviderApp/wish-api/reportAll";
		// invoke the API service/Operation
		ResponseEntity<String> response = template.exchange(baseUrl, HttpMethod.GET, null, String.class);
		// show the results
		System.out.println("output is::" + response.getBody());
		System.out.println("status code is::" + response.getStatusCodeValue());
		System.out.println("status code::" + response.getStatusCode());

		System.out.println("====================================");
		// convertList/array of docs to List<Actor> object
		ObjectMapper mapper = new ObjectMapper();
		List<Actor> actor = mapper.readValue(response.getBody(), new TypeReference<List<Actor>>(){} );
		actor.forEach(System.out::println);

	}

}
