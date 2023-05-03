package com.portfolio.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "img")
	private String img;
	@Column(name = "mail")
	private String mail;
	@Column(name = "phone")
	private String phone;
	@Column(name = "location")
	private String location;
	@Column(name = "description")
	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	@OrderBy("name ASC")
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Set<Skill> skills;
	
	@OneToMany(cascade = CascadeType.ALL)
	@OrderBy("name ASC")
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Set<Project> project;
	
	@OneToMany(cascade = CascadeType.ALL)
	@OrderBy("name ASC")
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Set<SocialMedia> social;
	
	@OneToMany(cascade = CascadeType.ALL)
	@OrderBy("name ASC")
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Set<Education> education;

	public Person() {
		super();
	}

	public Person(Long id, String name, int age, String img, String mail, String phone,
			String location, String description, Set<Skill> skills) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.img = img;
		this.mail = mail;
		this.phone = phone;
		this.location = location;
		this.description = description;
		this.skills = skills;
	}

}
