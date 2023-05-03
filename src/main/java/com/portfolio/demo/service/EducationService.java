package com.portfolio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.model.Education;
import com.portfolio.demo.repository.EducationRepository;

@Service
public class EducationService  implements IEducationService{
	
	@Autowired
	EducationRepository educationRepository;
	
	@Override
	public Education saveEducation(Education education) {
		return educationRepository.save(education);
	}
	
	@Override
	public Education getEducation(Long id) {
		return educationRepository.findById(id).orElse(null);
	}

	
	@Override
	public void deleteEducation(Long id) {
		educationRepository.deleteById(id);
	}


}
