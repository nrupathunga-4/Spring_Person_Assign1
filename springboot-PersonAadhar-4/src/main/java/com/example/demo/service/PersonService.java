package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.AadharRepository;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AadharRepository aadharRepository;
	
	public Person savePerson(Person person)
	{
		return personRepository.save(person);
	}
	
	public Optional<Person> getPersonById(long id)
	{
		return personRepository.findById(id);
	}
	
	public Person updatePerson(Person person,long id)
	{
		Person person2=personRepository.findById(id).orElse(null);
		person2.setFirstname(person.getFirstname());
		person2.setLastname(person2.getLastname());
		person2.setAge(person2.getAge());
		
		personRepository.save(person2);
		return person2;
	}
	public void deletePerson(long id)
	{
		personRepository.findById(id).orElse(null);
		personRepository.deleteById(id);
	}
}
