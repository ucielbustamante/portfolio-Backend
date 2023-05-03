package com.portfolio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.demo.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{

}
