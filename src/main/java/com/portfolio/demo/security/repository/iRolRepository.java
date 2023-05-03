package com.portfolio.demo.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.demo.security.entity.Rol;
import com.portfolio.demo.security.enums.RolName;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Long> {

	Optional<Rol> findByRolName(RolName roleName);
}
