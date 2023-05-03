package com.portfolio.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.portfolio.demo.model.Skill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillEditDto {
	
	private Long id;
	private String name;
	private String value;
	private List<PersonEditDto> personAssociated;
	
	public SkillEditDto(Skill skill) {
		this.id = skill.getId();
		this.name = skill.getName();
		this.value = skill.getValue();
		personAssociated = new ArrayList<PersonEditDto>();
	}
	
}
