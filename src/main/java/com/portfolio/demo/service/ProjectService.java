package com.portfolio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.model.Project;
import com.portfolio.demo.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService{

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
	@Override
	public Project getProject(Long id) {
		return projectRepository.findById(id).orElse(null);
	}
	
	@Override
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}


}
