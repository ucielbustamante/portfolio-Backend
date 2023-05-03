package com.portfolio.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter

@JsonIgnoreProperties(value = { "person" })
@Entity
public class Skill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	@Column(name="value")
	private String value;
	@ManyToOne(fetch = FetchType.LAZY)
	private Person person;

	
	public Skill() {
		super();
	}	

	public Skill(Long id, String name, String value, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.person = person;
	}

	
}
