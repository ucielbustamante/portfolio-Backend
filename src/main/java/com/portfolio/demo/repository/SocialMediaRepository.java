package com.portfolio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.demo.model.SocialMedia;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long>{

}
