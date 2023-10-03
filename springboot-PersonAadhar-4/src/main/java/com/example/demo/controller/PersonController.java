package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import jakarta.validation.Valid;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/save")
	public ResponseEntity<Person> savePerson(@Valid  @RequestBody Person person)
	{
		return new ResponseEntity<Person>(personService.savePerson(person),HttpStatus.CREATED);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable long id)
	{
		Optional<Person> person=personService.getPersonById(id);
		return person.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person,@PathVariable  long id)
	{
		return new ResponseEntity<Person>(personService.updatePerson(person, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable long id)
	{
		personService.deletePerson(id);
		return new ResponseEntity<String>("Person is Deleted From Database",HttpStatus.OK);
	}
}

