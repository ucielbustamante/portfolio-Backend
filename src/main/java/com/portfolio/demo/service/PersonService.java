package com.portfolio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.model.Person;
import com.portfolio.demo.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {
	@Autowired
	public PersonRepository personRepository;
	
	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	@Override
	public Person getPerson(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	@Override
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}

}
