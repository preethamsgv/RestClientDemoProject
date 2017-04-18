package com.infy.SpringBootRest.controller;

import java.util.Collection;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.SpringBootRest.model.Greeting;
import com.infy.SpringBootRest.service.GreetingService;   

@RestController
public class GreetingController {
	@Autowired
	GreetingService greetingService;

	@RequestMapping(value = "/api/greetings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Greeting>> getGreetings() {
		Collection<Greeting> greetings = greetingService.findAll();

		return new ResponseEntity<Collection<Greeting>>(greetings, HttpStatus.OK);  
	}

	@RequestMapping(value = "/api/greeting/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> getGreeting(@PathVariable("id") Long id) {

		Greeting greeting = greetingService.findOne(id);

		if (greeting == null) {
			return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

	@RequestMapping(value = "api/greeting", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting) {

		Greeting gCreate = greetingService.create(greeting);

		return new ResponseEntity<Greeting>(gCreate, HttpStatus.CREATED);

	} 

	@RequestMapping(value = "api/greeting/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> updateGreeting(@PathVariable("id") Long id,@RequestBody Greeting greeting) {

		Greeting gUpdate = greetingService.update(id,greeting);

		if (gUpdate == null) {
			return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Greeting>(gUpdate, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/greeting/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") Long id) {

		greetingService.delete(id);
		return new ResponseEntity<Greeting>(HttpStatus.NO_CONTENT);

	}
}
