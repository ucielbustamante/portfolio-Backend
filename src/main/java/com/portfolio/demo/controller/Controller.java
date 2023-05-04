package com.portfolio.demo.controller;

import javax.management.AttributeNotFoundException;
import com.mysql.cj.util.StringUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.demo.dto.PersonEditDto;
import com.portfolio.demo.model.Education;
import com.portfolio.demo.model.Person;
import com.portfolio.demo.model.Project;
import com.portfolio.demo.model.Skill;
import com.portfolio.demo.model.SocialMedia;
import com.portfolio.demo.service.IEducationService;
import com.portfolio.demo.service.IPersonService;
import com.portfolio.demo.service.IProjectService;
import com.portfolio.demo.service.ISkillService;
import com.portfolio.demo.service.ISocialMediaService;

@RestController
@CrossOrigin(origins = "https://portfolio-frontend-5a014.web.app/")
public class Controller {

	@Autowired
	public IPersonService iPersonService;
	
	@Autowired
	public ISkillService iSkillService;

	@Autowired
	public IProjectService iProjectService;
	
	@Autowired
	public ISocialMediaService iSocialMediaService;
	
	@Autowired
	public IEducationService iEducationService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/person/new")
	public void createPerson(@RequestBody Person person) {
		iPersonService.savePerson(person);
	}
	
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable Long id) {
		return iPersonService.getPerson(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/person/edit/{id}")
	public ResponseEntity<PersonEditDto> editPerson(@PathVariable Long id, 
			@RequestBody Person person) throws AttributeNotFoundException {
		Person personEdit = iPersonService.getPerson(id);
		if(!StringUtils.isEmptyOrWhitespaceOnly(person.getName()))
			personEdit.setName(person.getName());
		if(person.getAge() != 0 && person.getAge() > 0)
			personEdit.setAge(person.getAge());
		if(!StringUtils.isEmptyOrWhitespaceOnly(person.getImg()))
			personEdit.setImg(person.getImg());
		if(!StringUtils.isEmptyOrWhitespaceOnly(person.getMail()))
			personEdit.setMail(person.getMail());
		if(!StringUtils.isEmptyOrWhitespaceOnly(person.getPhone()))
			personEdit.setPhone(person.getPhone());
		if(!StringUtils.isEmptyOrWhitespaceOnly(person.getLocation()))
			personEdit.setLocation(person.getLocation());
		if(!StringUtils.isEmptyOrWhitespaceOnly(person.getDescription()))
			personEdit.setDescription(person.getDescription());
		PersonEditDto personEditDto = new PersonEditDto(personEdit);
		iPersonService.savePerson(personEdit);
		ResponseEntity<PersonEditDto> entity = new ResponseEntity<PersonEditDto>(personEditDto, HttpStatus.OK);
		return entity;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/person/delete/{id}")
	public void deletePerson(@PathVariable Long id) {
		iPersonService.deletePerson(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/skill/new/{id}")
	public void createSkill(@RequestBody Skill skill, @PathVariable Person id) {
		skill.setPerson(id);
		iSkillService.saveSkill(skill);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/skill/edit/{id}")
	public ResponseEntity<Skill> editSkill(@PathVariable Long id,
			@RequestBody Skill skill) {
		Skill skillEdit = iSkillService.getSkill(id);
		if(!StringUtils.isEmptyOrWhitespaceOnly(skill.getName()))
			skillEdit.setName(skill.getName());
		if(!StringUtils.isEmptyOrWhitespaceOnly(skill.getValue()))
			skillEdit.setValue(skill.getValue());
		iSkillService.saveSkill(skillEdit);
		return ResponseEntity.ok(skillEdit);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/skill/delete/{id}")
	public void deleteSkill(@PathVariable Long id) {
		iSkillService.deleteSkill(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/project/new/{id}")
	public void createProject(@RequestBody Project project, @PathVariable Person id) {
		project.setPerson(id);
		iProjectService.saveProject(project);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/project/edit/{id}")
	public ResponseEntity<Project> editProject(@PathVariable Long id,
			@RequestBody Project project){
		Project projectEdit = iProjectService.getProject(id);
		if(!StringUtils.isEmptyOrWhitespaceOnly(project.getName()))
			projectEdit.setName(project.getName());
		if(!StringUtils.isEmptyOrWhitespaceOnly(project.getImg()))
			projectEdit.setImg(project.getImg());
		if(!StringUtils.isEmptyOrWhitespaceOnly(project.getDescription()))
			projectEdit.setDescription(project.getDescription());
		iProjectService.saveProject(projectEdit);
		return ResponseEntity.ok(projectEdit);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/project/delete/{id}")
	public void deleteProject(@PathVariable Long id) {
		iProjectService.deleteProject(id);
	}
	
	@PostMapping("/socialMedia/new/{id}")
	public void createSocialMedia(@PathVariable Person id, @RequestBody SocialMedia socialMedia) {
		socialMedia.setPerson(id);
		iSocialMediaService.saveSocialMedia(socialMedia);
	}
	
	@PutMapping("/socialMedia/edit/{id}")
	public ResponseEntity<SocialMedia> editSocialMedia(@PathVariable Long id, 
			@RequestBody SocialMedia socialMedia){
		SocialMedia editSocialMedia = iSocialMediaService.getSocialMedia(id);
		if(!StringUtils.isEmptyOrWhitespaceOnly(socialMedia.getName()))
			editSocialMedia.setName(socialMedia.getName());
		if(!StringUtils.isEmptyOrWhitespaceOnly(socialMedia.getImg()))
			editSocialMedia.setImg(socialMedia.getImg());
		if(!StringUtils.isEmptyOrWhitespaceOnly(socialMedia.getLink()))
			editSocialMedia.setLink(socialMedia.getLink());
		iSocialMediaService.saveSocialMedia(editSocialMedia);
		return ResponseEntity.ok(editSocialMedia);
	}
	
	@DeleteMapping("/socialMedia/delete/{id}")
	public void deleteSocialMedia(@PathVariable Long id) {
		iSocialMediaService.deleteSocialMedia(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/education/new/{id}")
	public void createEducation(@RequestBody Education education, @PathVariable Person id) {
		education.setPerson(id);
	    iEducationService.saveEducation(education);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/education/edit/{id}")
	public ResponseEntity<Education> editEducation(@PathVariable Long id,
			@RequestBody Education education) throws AttributeNotFoundException {
		Education editEducation = iEducationService.getEducation(id);
		if (!StringUtils.isEmptyOrWhitespaceOnly(education.getName()))
			editEducation.setName(education.getName());
		if (!StringUtils.isEmptyOrWhitespaceOnly(education.getImg()))
			editEducation.setImg(education.getImg());
		if (!StringUtils.isEmptyOrWhitespaceOnly(education.getStatus()))
			editEducation.setStatus(education.getStatus());
		iEducationService.saveEducation(editEducation);
		return ResponseEntity.ok(editEducation);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/education/delete/{id}")
	public void deleteEducation(@PathVariable Long id) {
		iEducationService.deleteEducation(id);
	}
	
}
