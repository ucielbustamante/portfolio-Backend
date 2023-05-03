package com.portfolio.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.portfolio.demo.model.Person;
import com.portfolio.demo.model.Skill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonEditDto {
	
	private Long id;
	private String name;
	private int age;
	private String img;
	private String mail;
	private String phone;
	private String location;
	private String description;
	private List<SkillEditDto> associatedSkills;


	public PersonEditDto() {
		super();
	}


	public PersonEditDto(Person person) {
		this.id = person.getId();
		this.name = person.getName();
		this.age = person.getAge();
		this.img = person.getImg();
		this.mail = person.getMail();
		this.phone = person.getPhone();
		this.location = person.getLocation();
		this.description = person.getDescription();
		this.associatedSkills = new ArrayList<SkillEditDto>();
		for (Skill skill : person.getSkills()) {
			SkillEditDto dto = new SkillEditDto(skill);
			associatedSkills.add(dto);
		}
		
	}
	

	
}
