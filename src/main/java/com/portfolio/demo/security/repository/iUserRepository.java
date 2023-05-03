package com.portfolio.demo.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.demo.security.entity.User;

@Repository
public interface iUserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail (String email);
	Optional<User> findByUsername (String username);
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
}
