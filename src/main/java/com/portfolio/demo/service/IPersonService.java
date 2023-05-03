package com.portfolio.demo.service;

import com.portfolio.demo.model.Person;


public interface IPersonService {
	
	public Person savePerson(Person person);
	public Person getPerson(Long id);
	public void deletePerson(Long id);
	
}
