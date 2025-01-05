package com.tm.systm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.systm.db.Task;
import com.tm.systm.db.User;
import com.tm.systm.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(Long userId) {
    	 User user = new User();
         user.setId(userId);
         return taskRepository.findByUser(user);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}

