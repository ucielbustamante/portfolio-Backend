package com.portfolio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.demo.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{

}
