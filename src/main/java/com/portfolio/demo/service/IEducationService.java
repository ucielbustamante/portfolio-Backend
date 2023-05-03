package com.portfolio.demo.service;

import com.portfolio.demo.model.Education;

public interface IEducationService {
	public Education saveEducation(Education education);
	public Education getEducation(Long id);
	public void deleteEducation(Long id);
}
