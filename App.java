package com.infy.SpringBootRest;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.infy.SpringBootRest.model.Greeting;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App {
	private static Log log = LogFactory.getLog(App.class);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);

		RestTemplate restTemplate = new RestTemplate();
	/*	//Get collection
		Collection<Greeting> greetings = restTemplate.getForObject("http://localhost:8080/api/greetings",
				Collection.class);
		log.info(greetings.toString());
		
		//Get with ID
		String uri = "http://localhost:8080/api/greeting/{id}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		Greeting result = restTemplate.getForObject(uri, Greeting.class, params);
		log.info(result.toString());

		//Http post
		Greeting postGreeting = new Greeting();
		postGreeting.setId(8L);
		postGreeting.setText("Eight One");

		String posturi = "http://localhost:8080/api/greeting";
		Greeting postResult = restTemplate.postForObject(posturi, postGreeting, Greeting.class);
		log.info(postResult.toString());*/
		
		//Http Put
		String putURI = "http://localhost:8080/api/greeting/{id}";
		Map<String, String> paramsPut = new HashMap<String, String>();
		paramsPut.put("id", "2");
		Greeting putGreeting = new Greeting(2L,"New text");
		  restTemplate.put ( putURI, putGreeting, paramsPut);
		
		
		//HTTP Delete
		/*restTemplate.delete ( uri,  params );*/
		
		
	}

	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Greeting greeting = restTemplate.getForObject("http://localhost:8080/api/greeting/1", Greeting.class);
			log.info(greeting.toString());
		};
	}*/
}
