package com.tm.systm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tm.systm.db.Task;
import com.tm.systm.db.User;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);

	  @Query("SELECT t FROM Task t WHERE t.dueDate BETWEEN :currentTime AND :next24Hours")
	    List<Task> findTasksDueWithin24Hours(@Param("currentTime") java.time.LocalDateTime currentTime, 
	                                          @Param("next24Hours") java.time.LocalDateTime next24Hours);
	}

