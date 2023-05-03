package com.portfolio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{

}
