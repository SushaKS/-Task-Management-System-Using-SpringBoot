package com.tm.systm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.systm.db.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}


