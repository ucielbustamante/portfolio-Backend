package com.portfolio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.demo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
