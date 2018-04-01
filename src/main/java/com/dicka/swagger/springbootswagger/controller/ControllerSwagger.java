package com.dicka.swagger.springbootswagger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dicka.swagger.springbootswagger.entities.Greeting;

@RestController
@RequestMapping(value = "/api")
public class ControllerSwagger {

	private List<Greeting> greetings;
	
	public ControllerSwagger(){
		greetings = new ArrayList<Greeting>();
		greetings.add(new Greeting("Hallo"));
		greetings.add(new Greeting("Assalamualaikum"));
		greetings.add(new Greeting("Hi"));
	}
	
	@GetMapping("/{id}")
	public Greeting getId(@PathVariable (value = "id")final int id){
		return greetings.get(id - 1);
	}
	
	@GetMapping("/random")
	public Greeting getRandom(){
		return greetings.get(new Random().nextInt(greetings.size()));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createGreet(@RequestBody Greeting greeting){
		greetings.add(greeting);
	}
}
