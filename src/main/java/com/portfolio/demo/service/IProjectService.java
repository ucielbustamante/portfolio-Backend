package com.portfolio.demo.service;

import com.portfolio.demo.model.Project;

public interface IProjectService {

	public Project saveProject(Project project);
	public Project getProject(Long id);
	public void deleteProject(Long id);
}
