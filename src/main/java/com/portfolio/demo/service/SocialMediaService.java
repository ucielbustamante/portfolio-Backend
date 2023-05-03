package com.portfolio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.model.SocialMedia;
import com.portfolio.demo.repository.SocialMediaRepository;

@Service
public class SocialMediaService implements ISocialMediaService{
	
	@Autowired
	SocialMediaRepository socialMediaRepository;
		
	@Override
	public SocialMedia saveSocialMedia(SocialMedia socialMedia) {
		return socialMediaRepository.save(socialMedia);
	}
	
	@Override
	public SocialMedia getSocialMedia(Long id) {
		return socialMediaRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteSocialMedia(Long id) {
		socialMediaRepository.deleteById(id);
	}

}
