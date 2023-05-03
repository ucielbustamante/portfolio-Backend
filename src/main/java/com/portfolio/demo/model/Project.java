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
public class Project  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="img")
	private String img;
	@Column(name = "description")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	private Person person;
	
	public Project() {
		super();
	}
	
	public Project(Long id, String name, String img, String description, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.description = description;
		this.person = person;
	}

	
}