package com.tm.systm.db;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String title;
	    private String description;
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

	    public Task() {
	    }

	    public Task(String title, String description) {
	        this.title = title;
	        this.description = description;
	    }

	    @Enumerated(EnumType.STRING)
	    private TaskStatus status;

	    private LocalDateTime dueDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public TaskStatus getStatus() {
			return status;
		}

		public void setStatus(TaskStatus status) {
			this.status = status;
		}

		public LocalDateTime getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDateTime dueDate) {
			this.dueDate = dueDate;
		}

	    
	

	public enum TaskStatus {
	    PENDING, COMPLETED
	}
}


